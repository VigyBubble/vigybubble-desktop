package com.effortcure.service.interfaces;

import com.effortcure.dto.request.DirectoryRequestDTO;
import com.effortcure.dto.response.ApiResponse;
import com.effortcure.enums.BubbleType;
import java.util.List;

public interface BubbleServiceInterface {   
public ApiResponse<Void> createBubble(String name,String description,BubbleType type,String teamUuid,List<String> applicationsNameList,List<DirectoryRequestDTO> directoriesList) 
throws Exception ;
  
    
}
