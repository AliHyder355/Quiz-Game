package com.quiz.kbc.Services;

import com.quiz.kbc.Adapters.AnswersAdapter;
import com.quiz.kbc.Adapters.QuestionAdapter;
import com.quiz.kbc.DTO.AnswerDto;
import com.quiz.kbc.DTO.QuestionsDto;
import com.quiz.kbc.Entities.Answer;
import com.quiz.kbc.Entities.Questions;
import com.quiz.kbc.Repositories.QuestionsRepository;
import com.quiz.kbc.Services.Interfaces.QuestionService;
import com.quiz.kbc.Utility.QuestionCategory;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionsRepository questionsRepository;
    @Override
    public QuestionsDto addQuestion(QuestionsDto questionsDto) throws Exception {
        QuestionAdapter questionAdapter = new QuestionAdapter();

       Questions qstn = questionAdapter.DtoToDao(questionsDto);
        questionsRepository.save(qstn);

        return questionsDto;
    }

    @Override
    public List<QuestionsDto> getAllQuestions() throws Exception {
        QuestionAdapter questionAdapter = new QuestionAdapter();
        List<QuestionsDto> questionsDtoList = new ArrayList<>();

        for (Questions questions : questionsRepository.findAll()) {
            QuestionsDto questionsDto = questionAdapter.DaoToDto(questions);
            questionsDtoList.add(questionsDto);

        }
        return questionsDtoList;
    }

    @Override
    public QuestionsDto getQuestionById(int id) throws Exception {
        Questions questions = questionsRepository.findById(id).get();
        QuestionAdapter questionAdapter = new QuestionAdapter();

       return questionAdapter.DaoToDto(questions);
    }
    @Transactional
    @Override
    public QuestionsDto updateQuestion(QuestionsDto questionsDto) throws Exception {
        List<Answer> answers = new ArrayList<>();
        AnswersAdapter answersAdapter = new AnswersAdapter();
        Questions questions = questionsRepository.findById(questionsDto.getQuestionId()).get();

        questions.setQuestionID(questionsDto.getQuestionId());
        questions.setQuestion(questionsDto.getQuestion());

        switch (questionsDto.getQuestionCategory()){
            case "Computer":
                questions.setQstnCategory(QuestionCategory.COMPUTER);
                break;

            case "General Science":
                questions.setQstnCategory(QuestionCategory.GENERAL_SCIENCE);
                break;

            case "History":
                questions.setQstnCategory(QuestionCategory.HISTORY);
                break;

            case "Pakistan Studies":
                questions.setQstnCategory(QuestionCategory.PAKISTAN_STUDIES);
                break;
        }
        for(AnswerDto ans: questionsDto.getAnswers()){
            answers.add(answersAdapter.DtoToDao(ans));
        }


      //  questions.setAns(answers);

      // questionsRepository.save(questions);

        return questionsDto;
    }

    @Override
    public void deleteQuestion(int id) throws Exception {
        questionsRepository.deleteById(id);
    }
}
