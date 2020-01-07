package com.yuansong.study.mdd.boot.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages="com.yuansong.study.mdd")
public class MddBootDemoApplication {

	public static void main(String[] args) {
		
		long beginTime = System.currentTimeMillis();
		
		SpringApplication.run(MddBootDemoApplication.class, args);
		
		long endTime = System.currentTimeMillis();
		
		System.out.println("\n" + 
				"-----------------------------------------------------------------------\n" +
                "-----------------------------------------------------------------------\n" +
                "                               _     _\n" +
                "                              ( \\---/ )\n" +
                "                               ) . . (\n" +
                "-------------------------,--._(___Y___)_,--.---------------------------\n" +
                "                         `--'           `--'\n" +
                "                             mdd 启动成功                         \n" +
                "\n" +
                " 启动耗时: " + (endTime - beginTime) + "毫秒 \n" +
//                " 端口: 7060 \n" +
//                " 监控系统访问地址: http://127.0.0.1:7050/shangzhou_20190801_0000.html \n" +
                "-----------------------------------------------------------------------\n" +
                "-----------------------------------------------------------------------\n");
	}
}
