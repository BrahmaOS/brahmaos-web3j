package org.web3j.protocol.core;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicLong;

import rx.Observable;

import org.web3j.protocol.Web3jService;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Request<S, T extends Response> {
    private static AtomicLong nextId = new AtomicLong(0);

    @JsonProperty("jsonrpc")
    private String jsonrpc = "2.0";

    @JsonProperty("method")
    private String method;

    @JsonProperty("params")
    private List<S> params;

    @JsonProperty("id")
    private long id;

    private Web3jService web3jService;

    // Unfortunately require an instance of the type too, see
    // http://stackoverflow.com/a/3437930/3211687
    private Class<T> responseType;

    public Request() {
    }

    public Request(String method, List<S> params,
                   Web3jService web3jService, Class<T> type) {
        this.method = method;
        this.params = params;
        this.id = nextId.getAndIncrement();
        this.web3jService = web3jService;
        this.responseType = type;
    }

    public String getJsonrpc() {
        return jsonrpc;
    }

    public void setJsonrpc(String jsonrpc) {
        this.jsonrpc = jsonrpc;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public List<S> getParams() {
        return params;
    }

    public void setParams(List<S> params) {
        this.params = params;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public T send() throws IOException {
        return web3jService.send(this, responseType);
    }

    public Future<T> sendAsync() {
        return  web3jService.sendAsync(this, responseType);
    }

    public Observable<T> observable() {
        return new RemoteCall<T>(new Callable<T>() {
            @Override
            public T call() throws Exception {
                return Request.this.send();
            }
        }).observable();
    }
}
