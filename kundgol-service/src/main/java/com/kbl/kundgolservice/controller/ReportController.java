package com.kbl.kundgolservice.controller;

import com.kbl.kundgolservice.dto.ResponseDto;
import com.kbl.kundgolservice.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
//@RequestMapping("/kundgol")
public class ReportController {


    @Autowired
    private ReportService reportService;

    @GetMapping("/admin/report/person")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<ResponseDto> fetchReportByPerson(@RequestParam Long personId){
        ResponseDto response = reportService.fetchReportByPerson( personId);
        if (response !=null)
            return  new ResponseEntity<>(response,HttpStatus.FOUND);
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
    @GetMapping("/admin/report/general")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<ResponseDto> fetchGeneralReport(@RequestParam String placeCode, @RequestParam String wardCode){
        ResponseDto response = reportService.fetchGeneralReport(placeCode, wardCode);
        if (response !=null)
            return  new ResponseEntity<>(response,HttpStatus.FOUND);
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
}
