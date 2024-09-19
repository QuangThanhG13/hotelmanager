package com.example.hotelmanager.service.impl;
import com.example.hotelmanager.entity.Room;
import com.example.hotelmanager.repository.PagnitionRepository;
import com.example.hotelmanager.service.PagnitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PaginitionServiceImpl implements PagnitionService {

    @Autowired
    PagnitionRepository pagnitionRepository;

    public List<Room> getRoomSeach(Integer pageNo, Integer pageSize, String sortBy) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        Page<Room> pageResult = pagnitionRepository.findAll(paging);
        if (pageResult.hasContent()) {
            return pageResult.getContent();
        } else {
            return new ArrayList<>();
        }
    }
}
