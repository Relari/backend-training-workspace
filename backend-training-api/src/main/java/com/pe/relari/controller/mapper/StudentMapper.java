package com.pe.relari.controller.mapper;

import com.pe.relari.backendtrainingapi.model.api.AddressResponse;
import com.pe.relari.backendtrainingapi.model.api.StudentRequest;
import com.pe.relari.backendtrainingapi.model.api.StudentDetailResponse;
import com.pe.relari.backendtrainingapi.model.api.StudentResponse;
import com.pe.relari.backendtrainingapi.model.business.Address;
import com.pe.relari.backendtrainingapi.model.business.Student;
import com.pe.relari.backendtrainingapi.util.StudentConstant;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import java.util.List;

/**
 * <b>Interface:</b> StudentMapper.<br/>
 * @author RLR
 * @version 1.0.0
 */

@Mapper(componentModel = "spring")
public interface StudentMapper {

  @Mapping(source = "email", target = "address.email")
  @Mapping(source = "phoneNumber", target = "address.phoneNumber")
  @Mapping(target = "studentCode", expression = "java(generateStudentCodeDefault())")
  @Mapping(target = "status", expression = "java(Boolean.TRUE)")
  Student mapStudent(StudentRequest studentRequest);

  default String generateStudentCodeDefault() {
    return StudentConstant.GENERIC_CODE;
  }

  @Mapping(target = "studentCode", ignore = true)
  @Mapping(target = "documentIdentity", ignore = true)
  StudentResponse mapStudentInfoResponse(Student student);

  StudentResponse mapStudentResponse(Student student);

  StudentResponse mapStudentCodeResponse(String studentCode);

  default StudentDetailResponse mapStudentDetailResponse(List<StudentResponse> studentResponses) {
    return new StudentDetailResponse(studentResponses);
  }

  AddressResponse mapAddressResponse(Address address);

}
