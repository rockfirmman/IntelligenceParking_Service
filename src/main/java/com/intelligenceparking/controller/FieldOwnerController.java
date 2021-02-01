package com.intelligenceparking.controller;

import com.intelligenceparking.bean.FieldOwnerModel;
import com.intelligenceparking.response.CommonReturnType;
import com.intelligenceparking.service.FieldOwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/fieldOwner")
public class FieldOwnerController {
    @Autowired
    private FieldOwnerService fieldOwnerService;

    @RequestMapping("/insert")
    public CommonReturnType insert(
            @RequestParam(name = "fieldId") int fieldId,
            @RequestParam(name = "ownerId") int ownerId){
        FieldOwnerModel fieldOwnerModel = new FieldOwnerModel();
        fieldOwnerModel.setFieldId(fieldId);
        fieldOwnerModel.setOwnerId(ownerId);
        fieldOwnerService.insert(fieldOwnerModel);
        return CommonReturnType.create(null);
    }

    @RequestMapping("/selectByFieldId")
    public CommonReturnType selectOwnerByFieldId(@RequestParam(name = "fieldId") int fieldId) {
        List<FieldOwnerModel> fieldOwnerModel =  fieldOwnerService.selectByFieldId(fieldId);
        return CommonReturnType.create(fieldOwnerModel);
    }

    @RequestMapping("/selectByOwnerId")
    public CommonReturnType selectByOwnerId(@RequestParam(name = "ownerId") int ownerId) {
        List<FieldOwnerModel> fieldOwnerModel =  fieldOwnerService.selectByOwnerId(ownerId);
        return CommonReturnType.create(fieldOwnerModel);
    }

    @RequestMapping("/deleteFieldOwner")
    public CommonReturnType deleteFieldOwner(
            @RequestParam(name = "fieldId") int fieldId,
            @RequestParam(name = "ownerId") int ownerId){
        FieldOwnerModel fieldOwnerModel = new FieldOwnerModel();
        fieldOwnerModel.setFieldId(fieldId);
        fieldOwnerModel.setOwnerId(ownerId);
        fieldOwnerService.deleteFieldOwner(fieldOwnerModel);
        return CommonReturnType.create(null);
    }
}
