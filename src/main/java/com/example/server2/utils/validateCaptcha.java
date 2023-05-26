package com.example.server2.utils;
// This file is auto-generated, don't edit it. Thanks.

import com.aliyun.dysmsapi20170525.models.QuerySendDetailsResponse;
import com.aliyun.dysmsapi20170525.models.QuerySendDetailsResponseBody;
import com.aliyun.tea.*;
// This file is auto-generated, don't edit it. Thanks.

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class validateCaptcha {

    /**
     * 使用AK&SK初始化账号Client
     * @param accessKeyId
     * @param accessKeySecret
     * @return Client
     * @throws Exception
     */
    public static com.aliyun.dysmsapi20170525.Client createClient(String accessKeyId, String accessKeySecret) throws Exception {
        com.aliyun.teaopenapi.models.Config config = new com.aliyun.teaopenapi.models.Config()
                // 必填，您的 AccessKey ID
                .setAccessKeyId(accessKeyId)
                // 必填，您的 AccessKey Secret
                .setAccessKeySecret(accessKeySecret);
        // 访问的域名
        config.endpoint = "dysmsapi.aliyuncs.com";
        return new com.aliyun.dysmsapi20170525.Client(config);
    }

    public static List<QuerySendDetailsResponseBody.QuerySendDetailsResponseBodySmsSendDetailDTOsSmsSendDetailDTO> get() throws Exception {

        // 工程代码泄露可能会导致AccessKey泄露，并威胁账号下所有资源的安全性。以下代码示例仅供参考，建议使用更安全的 STS 方式，更多鉴权访问方式请参见：https://help.aliyun.com/document_detail/378657.html
        com.aliyun.dysmsapi20170525.Client client = validateCaptcha.createClient("LTAI5tLi2ZZkuCkd1XGxFNzY", "yQifNX6Xp8PUnVxZjK2kTPg2cBP5io");
        com.aliyun.dysmsapi20170525.models.QuerySendDetailsRequest querySendDetailsRequest = new com.aliyun.dysmsapi20170525.models.QuerySendDetailsRequest();
        querySendDetailsRequest.setPhoneNumber("15032898848");
        LocalDate date = LocalDate.now(); // get the current date
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
// this object contains the current date value
        querySendDetailsRequest.setSendDate(date.format(formatter));
        querySendDetailsRequest.setPageSize((long)10);
        querySendDetailsRequest.setCurrentPage((long)1);
        com.aliyun.teautil.models.RuntimeOptions runtime = new com.aliyun.teautil.models.RuntimeOptions();
        try {
            // 复制代码运行请自行打印 API 的返回值
           QuerySendDetailsResponse temp = client.querySendDetailsWithOptions(querySendDetailsRequest, runtime);
           return temp.getBody().smsSendDetailDTOs.getSmsSendDetailDTO();
        } catch (TeaException error) {
            // 如有需要，请打印 error
            com.aliyun.teautil.Common.assertAsString(error.message);
        } catch (Exception _error) {
            TeaException error = new TeaException(_error.getMessage(), _error);
            // 如有需要，请打印 error
            com.aliyun.teautil.Common.assertAsString(error.message);
        }
        return null;
    }
}
