package com.zhg.api;

import com.alibaba.dubbo.config.annotation.Reference;
import com.zhg.common.fastDFS.FastDFSClient;
import com.zhg.common.responseResult.ResponseResult;
import com.zhg.pojo.User;
import com.zhg.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/user")
@Api(value = "/user", tags = { "测试接口user" })
public class UserControll {

    @Reference(version = "1.0",timeout = 6000)
    private UserService userService;

    @ApiOperation(value = "通过用户名查询用户信息", response = User.class, httpMethod = "GET", notes = "通过用户名查询用户信息")
    @RequestMapping(value = "/find",method = RequestMethod.GET)
    public ResponseResult findByName(String name){
        return userService.findUserByName(name);
    }

    @ApiOperation(value = "上传文件", response = User.class, httpMethod = "POST", notes = "上传文件")
    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    public ResponseResult findByName(@RequestParam("file")MultipartFile file){
        try{
            FastDFSClient fast = new FastDFSClient();
            String fileAbsolutePath = fast.uploadFile(file.getBytes(),file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1));
            return ResponseResult.success(fileAbsolutePath);
        }catch (Exception e){
            return ResponseResult.failure(e.getMessage());
        }

    }

}
