package org.web3j.protocol.core.methods.request;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Filter implementation as per <a href="https://github.com/ethereum/wiki/wiki/JSON-RPC#eth_newfilter">docs</a>
 */
public class ShhFilter extends Filter<ShhFilter> {

    @JsonProperty("to")
    private String to;

    public ShhFilter(String to) {
        super();
        this.to = to;
    }

    public String getTo() {
        return to;
    }

    @Override
    ShhFilter getThis() {
        return this;
    }
}
