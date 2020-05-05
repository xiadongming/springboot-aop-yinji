package com.example.demo.dtomapper;

import com.example.demo.dto.FileInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
public interface FileInfoMapper {

    public Integer insertFile(FileInfo fileInfo);

}
