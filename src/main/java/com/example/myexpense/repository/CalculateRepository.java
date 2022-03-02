package com.example.myexpense.repository;

import com.example.myexpense.dto.CalculateDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CalculateRepository {

    // 소비 리스트 넣기
    List<CalculateDto> insertExpendList();

    // 소비 리스트 가져오기
    List<CalculateDto> getExpendList();
}
