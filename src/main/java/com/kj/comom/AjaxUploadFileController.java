package com.kj.comom;

import com.kj.comom.util.FileUtils;
import com.kj.constant.HccConstant;
import com.kj.front.config.UploadImgConfig;
import com.kj.service.SuppImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @author yangyang
 * @version 1.0
 * @date 2019/9/23 下午5:44
 * @description
 */
@Controller
@RequestMapping("/ajax/")
public class AjaxUploadFileController {

    @Autowired
    private UploadImgConfig uploadImgConfig;


    @RequestMapping(value = "uploadFile.action")
    @ResponseBody
    public BaseResponse uploadFile(@RequestParam("file") MultipartFile file, HttpServletRequest request){

        try {
            if(!file.isEmpty()) {
                String key = uploadImgConfig.getUploadPath()+"c_"+ UUID.randomUUID().toString().replaceAll("-","")+ file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));//现在的文件名是时间戳加原文件名，出现图片相同时，读取不出来的bug
                FileUtils.copyInputStreamToFile(file.getInputStream(),new File(key));//将文件的输入流输出到一个新的文件
                //响应成功
                return CommonResultResponse.buildSuccess(key.substring(key.lastIndexOf(HccConstant.UPLOAD)));
            }else {
                //响应失败
                return BaseResponse.buildFail("上传失败，请选择文件");
            }
        } catch (IOException e) {
            //响应失败
            return BaseResponse.buildFail();
        }
    }






}
