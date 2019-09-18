package com._4paradigm.test.predictor;

import com._4paradigm.predictor.PredictRequest;
import com._4paradigm.predictor.PredictResponse;
import com._4paradigm.predictor.client.PredictorClient;

/**
 * Created by wangyiping on 18/09/2019 10:56 AM.
 */
public class ZhenAi {

    public static PredictResponse predict(PredictorClient predictorClient, PredictRequest pr) throws Exception {
        long start = System.currentTimeMillis();
        PredictResponse predictResponse = predictorClient.predict(pr);
        long end = System.currentTimeMillis();
        System.out.println("predict cost time: " + (end - start) + "ms");
        return predictResponse;
    }
}
