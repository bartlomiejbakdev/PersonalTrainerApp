package com.example.personaltrainer.questionnaire;

import com.example.personaltrainer.questionnaire.entity.Question;
import com.example.personaltrainer.questionnaire.model.QuestionOrder;
import com.example.personaltrainer.questionnaire.repository.QuestionRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("/admin")
public class QuestionnaireAdminController {

    private final QuestionnaireService questionnaireService;
    private final QuestionRepository questionRepository;

    public QuestionnaireAdminController(QuestionnaireService questionnaireService, QuestionRepository questionRepository) {
        this.questionnaireService = questionnaireService;
        this.questionRepository = questionRepository;
    }

    @GetMapping
    public String adminHello() {
        return "admin";
    }

    @GetMapping("/kwestionariusz")
    public String editQuestionnaire(Model model) {
        model.addAttribute("questions", questionnaireService.getQuestions());
        model.addAttribute("newQuestion", new Question());
        model.addAttribute("order", new QuestionOrder());
        return "admin-questionnaire";
    }

    @PostMapping("/kwestionariusz/question")
    public String addQuestion(@ModelAttribute Question question) {
        questionRepository.save(question);
        return "redirect:/admin/kwestionariusz";
    }

    @DeleteMapping("/kwestionariusz/question/{deleteId}")
    public String deleteQuestion(@PathVariable Long deleteId) {

        List<Question> questions = questionRepository.findAll();

        Long deletedOrderId = Objects.requireNonNull(questions.stream()
                .filter(question -> Objects.equals(question.getId(), deleteId))
                .findFirst()
                .orElse(null)).orderId;


        for (Question question : questions) {

            Long currentOrderId = question.getOrderId();
            if (currentOrderId > deletedOrderId) {
                question.setOrderId(currentOrderId - 1);
            }
        }

        questionRepository.saveAll(questions);
        questionRepository.deleteById(deleteId);
        return "redirect:/admin/kwestionariusz";
    }

    @PostMapping("/kwestionariusz/question/order")
    public String changeOrderQuestions(@ModelAttribute QuestionOrder questionOrder) {


        Question firstQuestion = questionRepository.findByOrderId(questionOrder.firstQuestionId - 1);
        Question secondQuestion = questionRepository.findByOrderId(questionOrder.secondQuestionId - 1);

        Long firstId = firstQuestion.orderId;
        firstQuestion.setOrderId(secondQuestion.orderId);
        secondQuestion.setOrderId(firstId);

        List<Question> updatedQuestions = Arrays.asList(firstQuestion, secondQuestion);
        questionRepository.saveAll(updatedQuestions);

        return "redirect:/admin/kwestionariusz";
    }
}
