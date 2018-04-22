package com.zjk.result;

import com.zjk.entity.FallThreshold;
import com.zjk.entity.TrainingSuggestData;

import java.util.ArrayList;

/**
 * author : ZhuangJinKun
 * e-mail : zhuangjinkun@bigo.sg
 * time   : 2018/04/20
 */

public class GetConfigResult extends Result {

    public int dynamicCount;
    public FallThreshold fallThreshold;
    public ArrayList<TrainingSuggestData> trainingSuggestDataArrayList;
}
