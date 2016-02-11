/**
 * MIT License

Copyright (c) 2015  Rob Terpilowski

Permission is hereby granted, free of charge, to any person obtaining a copy of this software 
and associated documentation files (the "Software"), to deal in the Software without restriction, 
including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, 
and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, 
subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING 
BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. 
IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, 
WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE 
OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */


package com.sumzerotrading.ib.example.market.data;

import com.sumzerotrading.data.StockTicker;
import com.sumzerotrading.interactive.brokers.client.InteractiveBrokersClient;
import com.sumzerotrading.marketdata.ILevel1Quote;
import com.sumzerotrading.marketdata.QuoteType;



public class MarketDataStocksExample {
    
    
    public void start() {
        InteractiveBrokersClient ibClient = new InteractiveBrokersClient("localhost", 6468, 1);
        ibClient.connect();
        
        StockTicker stockTicker=  new StockTicker("AMZN");
        
        ibClient.subscribeLevel1(stockTicker, (ILevel1Quote quote) -> {
            if( quote.getType().equals(QuoteType.LAST) ){
                System.out.println("Received Quote: " + quote.getValue() );
            }
        });
        
    }
    
    public static void main(String[] args) {
        new MarketDataStocksExample().start();
    }
}