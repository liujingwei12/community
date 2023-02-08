package com.nowcoder.community.controller;

import java.util.*;

class Solution {
    public List<String> alertNames(String[] keyName, String[] keyTime) {
        Map<String, List<String>> nameTimeList=
                new HashMap<String,List<String>>();
        int len=keyName.length;
        List<String> threeCopy=new ArrayList<String>();
        for(int i=0;i<len;i++){
            if(threeCopy.contains(keyName[i])){
                continue;
            }
            else{
                List<String> timeList=nameTimeList.get(keyName[i]);
                int count=0;
                if(timeList!=null){
                    timeList.add(keyTime[i]);
                    count=returnCount(timeList);
                    System.out.println(count);
                    if(count<2){
                        nameTimeList.put(keyName[i],timeList);
                    }
                    else{
                        threeCopy.add(keyName[i]);
                    }
                }
                else{
                    List<String> list=new ArrayList<>();
                    list.add(keyTime[i]);
                    nameTimeList.put(keyName[i],list);
                }
            }
        }
        Collections.sort(threeCopy);
        return threeCopy;
    }
    public boolean isCopy(String s1,String s2){
        String[] s1_a=s1.split(":");
        String[] s2_a=s2.split(":");
        int hourDif=Integer.parseInt(s2_a[0])-Integer.parseInt(s1_a[0]);
        int minDif=Integer.parseInt(s2_a[1])-Integer.parseInt(s1_a[1]);
        if(hourDif==0){
            return true;
        }
        else if(hourDif==1){
            if(minDif<=0){
                return true;
            }
            else{
                return false;
            }
        }
        else{
            return false;
        }
    }
    public int returnCount(List<String> list){
        Collections.sort(list);
        for(int i=0;i<list.size()-2;i++){
//            String[] s_a=list.get(i).split(":");
//            String s=(Integer.parseInt(s_a[0])+1)+":"+s_a[1];
//            System.out.println(s+"   "+list.get(i+2));
            if(isCopy(list.get(i),list.get(i+2))){
                return 2;
            }
        }
        return 0;
    }
}
class test{
    public static void main(String[] args) {
        Solution s=new Solution();
        String[] keyName={"a","a","a","a","a","b","b","b","b","b","b"};
        String[] keyTime={"02:30","23:19","23:28","23:59","21:05","22:04","04:57","05:17","12:27","17:34","00:09"};

        System.out.println(s.alertNames(keyName,keyTime));
//        System.out.println("22:04".compareTo("04:57"));
//        System.out.println("22:04".compareTo("05:17"));
//        Arrays.sort(keyTime);
//        for(int i=0;i<keyTime.length;i++){
//            System.out.println(keyTime[i]);
//        }
    }
}
