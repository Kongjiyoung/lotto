package com.example.demo.lotto;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class LottosService {
    private final LottosRepository lottosRepository;

    public LottosResponse.SaveDTO save(LottosRequest.SaveDTO reqestDTO) {
        Set<Integer> numbers = new HashSet<>();
        numbers.add(reqestDTO.getNumber1());
        numbers.add(reqestDTO.getNumber2());
        numbers.add(reqestDTO.getNumber3());
        numbers.add(reqestDTO.getNumber4());
        numbers.add(reqestDTO.getNumber5());
        numbers.add(reqestDTO.getNumber6());

        if (numbers.size() < 6) {
            throw new IllegalArgumentException("로또 번호는 중복될 수 없습니다.");
        }

        Lottos lottos = lottosRepository.save(reqestDTO.toEntity());

        return new LottosResponse.SaveDTO(lottos);
    }

    public List<Integer> generateLottoNumbers() {
        return new Random().ints(1, 46)
                .distinct()
                .limit(6)
                .boxed()
                .collect(Collectors.toList());
    }

    public int calculateRank(List<Integer> lottoNumbers, List<Integer> winningNumbers) {
        int matches = (int) lottoNumbers.stream().filter(winningNumbers::contains).count();

        if (matches == 6) {
            return 1; // 1등
        } else if (matches == 5) {
            return 2; // 2등
        } else if (matches == 4) {
            return 3; // 3등
        } else if (matches == 3) {
            return 4; // 4등
        } else if (matches == 2) {
            return 5; // 5등
        } else {
            return 0; // 당첨되지 않음
        }
    }
}
