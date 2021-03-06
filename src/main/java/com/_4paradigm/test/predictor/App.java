package com._4paradigm.test.predictor;

import com._4paradigm.predictor.PredictRequest;
import com._4paradigm.predictor.PredictResponse;
import com._4paradigm.predictor.brpc.client.PredictorBrpcClient;
import com._4paradigm.prophet.rest.utils.Serdes;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception
    {
        System.out.println( "Hello World!" );

        long serStart = System.currentTimeMillis();
        PredictRequest pr = Serdes.deserializeFromJson(FileUtils.readFileFromResourceToString("predictor.json"), PredictRequest.class);
        long serEnd = System.currentTimeMillis();
        System.out.println("Seri cost time: " + (serEnd - serStart) + "ms");


        long brpcStart = System.currentTimeMillis();
        PredictorBrpcClient predictorBrpcClient = new PredictorBrpcClient("172.16.32.7:31195", 3000, 3000);
        long brpcEnd = System.currentTimeMillis();
        System.out.println("Brpc client cost time: " + (brpcEnd - brpcStart) + "ms");

        Thread.sleep(3000);


        long predictStart = System.currentTimeMillis();
        for (int i=0; i<999; i++) {
            ZhenAi.predict(predictorBrpcClient, pr);
        }

        PredictResponse response = ZhenAi.predict(predictorBrpcClient, pr);
        long predictEnd = System.currentTimeMillis();
        System.out.println("Average 1000 cost time: " + (predictEnd - predictStart)/1000 + "ms");

        System.out.println(response.getInstances().get(2999).getScores());
    }

}
