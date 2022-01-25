package com.insurance.Insurance_spring.controller;

import com.insurance.Insurance_spring.entity.Accident;
import com.insurance.Insurance_spring.repository.AccidentRepository;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@RestController
public class AccidentApiController {
    private final AccidentService accidentService;

    @PostMapping("/api/v1/accident")
    public Long save(@RequestBody AccidentSaveRequestDto requestDto){
        return accidentService.save(requestDto);
    }
    @PutMapping("/api/v1/accident/{id}")
    public Long update(@PathVariable Long id, @RequestBody AccidentUpdateRequestDto requestDto){
        return accidentService.update(id, requestDto);
    }
    @GetMapping("/api/v1/accident/{id}")
    public AccidentResponseDto findById(@PathVariable Long id){
        return accidentService.findById(id);
    }
}

@RequiredArgsConstructor
@Service
public class AccidentService{
    private final AccidentRepository accidentRepository;

    @Transactional
    public Long save(AccidentSaveRequestDto requestDto){
        return accidentRepository.save(requestDto.toEntity().getId());
    }
    @Transactional
    public Long update(Long id, AccidentUpdateRequestDto requestDto){
        Accident accident = AccidentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사고가 없습니다. id=" + id));
        accident.update(requestDto.getAccidentDate(), requestDto.getAccdientPlace());
        return id;
    }
    @Transactional
    public AccidentResponseDto findById(Long id){
        Accident entity = AccidentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사고가 없습니다. id=" + id));
        return new AccidentResponseDto(entity);
    }
}

@Getter
@NoArgsConstructor
public class AccidnetSaveRequestDto{
    private String accidentDate, accidentPlace;

    @Builder
    public AccidnetSaveRequestDto(String accidentDate, String accidentPlace){
        this.accidentDate = accidentDate;
        this.accidentPlace = accidentPlace;
    }
    public Accident toEntity(){
        return Accident.builder().accidentDate(accidentDate).accidentPlace(accidentPlace).build();
    }
}
@Getter
@NoArgsConstructor
class AccidentUpdateRequestDto{
    private Long completed, judged;

    @Builder
    public AccidentUpdateRequestDto(Long completed, Long judged) {
        this.completed = completed;
        this.judged = judged;
    }
}

class AccidentResponseDto{
    private Long accidentId, completed, judged, customerId;
    private String accidentDate, accidentPlace, accidentTime, accidentSize,date;

    public AccidentResponseDto(Accident entity){
        this.accidentId = entity.getAccidentId();
        this.accidentDate = entity.getAccidentDate();
        this.accidentPlace = entity.getAccidentPlace();
        this.accidentSize = entity.getAccidentSize();
        this.accidentTime = entity.getAccidentTime();
        this.completed = entity.getCompleted();
        this.judged = entity.getJudged();
        this.customerId = entity.getCustomerId();
    }
}