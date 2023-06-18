package com.quiz.kbc.Services;

import com.quiz.kbc.Adapters.AnswersAdapter;
import com.quiz.kbc.DTO.AnswerDto;
import com.quiz.kbc.Entities.Answer;
import com.quiz.kbc.Repositories.AnswerRepository;
import com.quiz.kbc.Services.Interfaces.AnswerService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AnswerServiceImpl implements AnswerService {
    @Autowired
    private AnswerRepository answerRepository;

    @Override
    public List<AnswerDto> getAllAns() throws Exception {
        List<AnswerDto> answerDtos = new ArrayList<>();
        AnswersAdapter answersAdapter = new AnswersAdapter();

        for (Answer answer : answerRepository.findAll()) {
            answerDtos.add(answersAdapter.DaoToDto(answer));
        }
        return answerDtos;
    }

    @Transactional
    @Override
    public AnswerDto updateAns(AnswerDto answerDto) throws Exception {
        AnswersAdapter answersAdapter = new AnswersAdapter();
        Answer answer = answerRepository.findById(answerDto.getAnsId()).get();

        answer.setAnsID(answerDto.getAnsId());
        answer.setAnswer(answerDto.getAnswer());
        answer.setCorrectAns(answerDto.getCorrectAns());

       return answersAdapter.DaoToDto(answer);
    }

    @Override
    public void deleteAns(int id) throws Exception {
        answerRepository.deleteById(id);
    }
}
