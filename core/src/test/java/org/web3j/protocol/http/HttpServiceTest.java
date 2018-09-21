package org.web3j.protocol.http;

import java.util.HashMap;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class HttpServiceTest {
    
    private HttpService httpService = new HttpService();
    
    @Test
    public void testAddHeader() {
        String headerName = "customized_header0";
        String headerValue = "customized_value0";
        httpService.addHeader(headerName, headerValue);
        assertTrue(httpService.getHeaders().get(headerName).equals(headerValue));
    }
    
    @Test
    public void testAddHeaders() {
        String headerName1 = "customized_header1";
        String headerValue1 = "customized_value1";
        
        String headerName2 = "customized_header2";
        String headerValue2 = "customized_value2";
        
        HashMap<String, String> headersToAdd = new HashMap<>();
        headersToAdd.put(headerName1, headerValue1);
        headersToAdd.put(headerName2, headerValue2);
        
        httpService.addHeaders(headersToAdd);
        
        assertTrue(httpService.getHeaders().get(headerName1).equals(headerValue1));
        assertTrue(httpService.getHeaders().get(headerName2).equals(headerValue2));
    }
    
}
