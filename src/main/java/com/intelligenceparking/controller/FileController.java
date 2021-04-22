package com.intelligenceparking.controller;

import com.intelligenceparking.response.CommonReturnType;
import com.intelligenceparking.tool.pythonRecognize.recognize;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Date;

@RestController
@RequestMapping("/file")
public class FileController {
    private BillController billController;
    private final String filePath = "C:/Users/rockfirmman/Desktop/";
//    private final String filePath = "/root/";
    @PostMapping("/uploadAvatar")
    public Object uploadAvatar(@RequestParam(name = "fileName") MultipartFile fileUpload, @RequestParam(name = "id") int id){
        //获取文件名
        String fileName = fileUpload.getOriginalFilename();
        System.out.println(fileName);
        //指定本地文件夹存储图片
        try {
            fileUpload.transferTo(new File(filePath+"Avatar/"+id+".jpg"));
            return CommonReturnType.create(null);
        } catch (Exception e) {
            e.printStackTrace();
            return CommonReturnType.create("fail");
        }
    }

    //上传停车场地图或图标
    @PostMapping("/uploadCoordinateOrPic")
    public Object uploadCoordinateOrPic(@RequestParam(name = "fileName") MultipartFile fileUpload, @RequestParam(name = "id") int id){
        //检测文件夹是否存在
        File file = new File(filePath+"Coordinate/"+id);
        if (!file.exists()) {
            file.mkdirs();
        }
        //获取文件名
        String fileName = fileUpload.getOriginalFilename();
        System.out.println(fileName);
        try {
            fileUpload.transferTo(new File(filePath+"Coordinate/"+id+"/"+fileName));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return CommonReturnType.create(null);
    }

    @PostMapping("/deleteCoordinateOrPic")
    public Object deleteCoordinateOrPic(@RequestParam(name = "fileName") String fileName, @RequestParam(name = "id") int id){
        File file = new File(filePath+"Coordinate/"+id);
        if (!file.exists()) {
            file.mkdirs();
            return CommonReturnType.create("删除失败，文件不存在","fail");
        }

        File deleteFile = new File(filePath+"Coordinate/"+id+"/"+fileName);
        if (!file.exists()) {
            System.out.println("删除文件失败:" + fileName + "不存在！");
            return CommonReturnType.create("删除失败，文件不存在","fail");
        }

        deleteFile.delete();

        return CommonReturnType.create(null);
    }

    @PostMapping("/downloadAvatar")
    public Object downloadAvatar(@RequestParam(name = "id") int id){
        File file = new File(filePath+"Avatar/"+id+".jpg");
        if (!file.exists())
            return CommonReturnType.create("下载失败，图片不存在","false");
        return export(file);
    }

    @PostMapping("/downloadCoordinateOrPic")
    public Object downloadCoordinateOrPic(@RequestParam(name = "id") int id,@RequestParam(name = "fileName") String fileName){
        File file = new File(filePath+"Coordinate/"+id+"/"+fileName);
        if (!file.exists())
            return CommonReturnType.create("下载失败，文件不存在","false");
        return export(file);
    }

    @PostMapping("/getCoordinateList")
    public CommonReturnType getCoordinateList(@RequestParam(name = "id") int id){
        File file = new File(filePath+"Coordinate/"+id);
        if (!file.exists())
            return CommonReturnType.create("下载失败，文件不存在","false");
        File[] fileList = file.listFiles();
        return CommonReturnType.create(fileList);
    }

    @RequestMapping(value = "test", method = RequestMethod.GET)
    public Object test(){
        File file = new File(filePath+"30.jpg");
        if (!file.exists())
            return CommonReturnType.create("下载失败，图片不存在","false");
        return export(file);
    }

    @PostMapping("/uploadLicensePic")
    public CommonReturnType uploadLicensePic(@RequestParam(name = "fileName") MultipartFile fileUpload, @RequestParam(name = "hardwareId") int hardwareId){
        //获取文件名
        String fileName = fileUpload.getOriginalFilename();
        System.out.println(fileName);
        //存储图片
        try {
            fileUpload.transferTo(new File(filePath + "License/" + fileName));
        } catch (Exception e) {
            e.printStackTrace();
        }
        //获取车牌号
        String commandPath = filePath + "recognize.py";
        String picPath = filePath + "License/" + fileName;
        String license = recognize.getLicense(commandPath,picPath);
        System.out.println(hardwareId + ": " + license);
        //删除图片
        File deleteFile = new File(filePath + "License/" + fileName);
        deleteFile.delete();
        if("null".equals(license)) return CommonReturnType.create("未检测到车辆","false");
        //TODO ,按照hardware id 寻找停车位，并入业务
        //
        billController.createBillByHardware(hardwareId,license);
        return CommonReturnType.create(license,"success");
    }



    public ResponseEntity<FileSystemResource> export(File file) {
        if (file == null) {
            return null;
        }
        HttpHeaders headers = new HttpHeaders();
        headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
        headers.add("Content-Disposition", "attachment; filename=" + file.getName());
        headers.add("Pragma", "no-cache");
        headers.add("Expires", "0");
        headers.add("Last-Modified", new Date().toString());
        headers.add("ETag", String.valueOf(System.currentTimeMillis()));

        return ResponseEntity .ok() .headers(headers) .contentLength(file.length()) .contentType(MediaType.parseMediaType("application/octet-stream")) .body(new FileSystemResource(file));
    }
}
