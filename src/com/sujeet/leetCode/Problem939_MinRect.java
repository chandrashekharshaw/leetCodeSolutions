package com.sujeet.leetCode;

import java.util.*;

public class Problem939_MinRect {

    public static int minAreaRect(int[][] points) {
        Map<Integer, List<Integer>> linesMap = new TreeMap<>();

        for(int[] point : points) {
            linesMap.computeIfAbsent(point[0], ylist-> new ArrayList<>()).add(point[1]);
        }

        int minArea = Integer.MAX_VALUE;
        Map<Integer, Integer> yPairEntries = new HashMap<>();
        for(Map.Entry<Integer, List<Integer>> line : linesMap.entrySet()) {
            int x = line.getKey();
            List<Integer> yVals = line.getValue();

            Collections.sort(yVals);
            for(int i = 0; i < yVals.size(); i++) {
                for(int j = i+1; j < yVals.size(); j++) {
                    int yLow = yVals.get(i);
                    int yHigh = yVals.get(j);
                    int encoding = yLow *4001 + yHigh;
                    if(yPairEntries.containsKey(encoding)) {
                        int prevX = yPairEntries.get(encoding);
                        int area = (x - prevX) * (yHigh- yLow);
                        if(prevX != x)
                            minArea = Math.min(minArea, area);
                    }
                    yPairEntries.put(encoding, x);
                }    //end j
            } // end i
        } // end for
        return minArea == Integer.MAX_VALUE ? 0 : minArea;
    }

    public static void main(String[]args) {
        Problem939_MinRect.minAreaRect(new int[][] {
                {33489,35488},{35453,25333},{33489,13087},{35453,28054},{33489,3192},{35453,32718},{33489,34158},{33489,28804},{33489,31324},{33489,10279},{35453,24627},{33489,16560},{33489,15995},{33489,32718},{35453,9172},{35453,11474},{35453,24648},{33489,8839},{33489,6218},{35453,32181},{35453,21472},{33489,19329},{33489,11187},{33489,14444},{35453,16560},{35453,5883},{35453,3442},{35453,30089},{35453,18602},{33489,33912},{33489,6673},{35453,14113},{35453,38039},{35453,24035},{35453,28804},{35453,36166},{33489,26912},{33489,3819},{33489,25556},{33489,21240},{35453,11106},{33489,33396},{33489,17271},{35453,21497},{35453,20923},{35453,8839},{33489,36166},{33489,6717},{35453,20212},{35453,5231},{35453,14741},{35453,12687},{35453,35547},{33489,3442},{35453,26312},{35453,1812},{33489,22809},{35453,9112},{35453,22405},{35453,7035},{33489,22482},{33489,37334},{35453,23418},{33489,1688},{33489,21497},{33489,8877},{33489,13883},{35453,38389},{35453,363},{35453,39062},{33489,2649},{35453,9347},{35453,13883},{35453,1481},{35453,39796},{33489,7234},{33489,39331},{35453,39790},{33489,7035},{35453,22482},{35453,15645},{35453,20073},{35453,26805},{35453,7211},{35453,33366},{33489,39608},{35453,1186},{33489,10490},{33489,3547},{35453,507},{33489,7677},{33489,15521},{35453,32512},{33489,10303},{33489,33154},{35453,14444},{33489,20089},{35453,39608},{35453,19316},{33489,32050},{33489,24648},{35453,15207},{33489,20679},{33489,11914},{33489,29908},{33489,2265},{35453,18691},{35453,22864},{35453,15396},{33489,33104},{33489,19932},{35453,39497},{33489,25529},{35453,3192},{33489,507},{35453,3547},{35453,8966},{33489,413},{35453,4779},{35453,2439},{35453,1688},{35453,15995},{35453,8158},{33489,3979},{33489,15137},{33489,33012},{35453,9163},{33489,21506},{33489,9112},{33489,33539},{35453,12866},{35453,8589},{35453,33104},{33489,26312},{33489,22688},{35453,13087},{33489,35668},{33489,39199},{35453,9678},{33489,39790},{35453,5000},{35453,6753},{33489,34008},{33489,9785},{35453,21240},{33489,9678},{35453,603},{35453,33912},{35453,14816},{33489,4597},{35453,39879},{33489,25302},{35453,1312},{35453,9785},{35453,38139},{33489,28851},{33489,15207},{33489,30580},{35453,6134},{35453,21143},{33489,14589},{35453,4398},{33489,20923},{33489,22405},{35453,27613},{35453,28851},{33489,4564},{35453,7745},{35453,7564},{35453,34229},{33489,29391},{33489,12579},{33489,14749},{35453,1338},{35453,20125},{33489,2492},{35453,23178},{33489,9452},{35453,29391},{33489,39497},{35453,24267},{33489,17560},{35453,20815},{35453,10490},{35453,24252},{35453,14429},{35453,26912},{35453,7694},{33489,2253},{35453,20089},{33489,12496},{33489,20815},{33489,24691},{35453,32959},{33489,12866},{33489,1312},{33489,24627},{33489,27912},{33489,20073},{33489,37268},{35453,6230},{33489,25333},{35453,17271},{33489,9172},{35453,35129},{35453,20679},{33489,8966},{35453,2649},{35453,8877},{33489,30089},{35453,39859},{33489,11528},{35453,9707},{33489,8589},{33489,5000},{35453,2590},{35453,1267},{33489,36760},{33489,7604},{35453,11187},{35453,6563},{35453,21785},{35453,6406},{33489,13192},{35453,413},{33489,31531},{33489,7745},{35453,20832},{33489,33141},{35453,25079},{33489,33366},{35453,17560},{35453,29379},{33489,11986},{33489,22579},{35453,6717},{35453,2152},{33489,38645},{33489,18602},{33489,20212},{35453,9889},{35453,9452},{33489,15396},{35453,2265},{35453,2492},{33489,23187},{33489,34918},{35453,22579},{35453,25556},{35453,39199},{35453,38645},{33489,31060},{35453,4033},{35453,36786},{35453,7677},{33489,4352},{33489,24267},{33489,6753},{33489,7564},{33489,21472},{33489,2819},{35453,3333},{33489,9347},{33489,38139},{33489,1481},{35453,12008},{35453,15137},{33489,24035},{33489,38039},{33489,10159},{33489,39879},{33489,25888},{35453,35488},{33489,11106},{33489,33077},{33489,5880},{35453,1709},{35453,34008},{35453,37379},{33489,1338},{33489,6224},{33489,32521},{35453,10303},{33489,37208},{35453,33154},{35453,14285},{35453,22311},{35453,24691},{33489,7211},{35453,14474},{33489,1186},{33489,21785},{35453,16280},{33489,14285},{33489,4398},{35453,37334},{35453,23187},{35453,7604},{33489,13079},{33489,1709},{35453,33396},{35453,3441},{35453,36760},{33489,363},{35453,4597},{33489,29379},{33489,39062},{35453,37208},{35453,932},{33489,22864},{35453,34918},{33489,35557},{35453,19932},{35453,35069},{33489,7957},{33489,35328},{33489,9163},{35453,27882},{35453,3979},{33489,13731},{33489,35129},{35453,12579},{35453,20334},{35453,33210},{35453,35328},{33489,28883},{35453,6761},{35453,37268},{33489,4779},{33489,14352},{33489,3441},{33489,39859},{33489,6406},{33489,10074},{35453,12164},{35453,31323},{33489,7694},{35453,12496},{35453,22375},{33489,23178},{33489,14429},{35453,35668},{35453,33539},{35453,32935},{35453,16813},{35453,17230},{35453,31324},{33489,1267},{33489,32922},{33489,17230},{35453,37393},{35453,33077},{33489,6230},{35453,7021},{33489,23418},{35453,17849},{35453,10074},{33489,11474},{33489,2152},{33489,13084},{33489,14113},{35453,15521},{33489,16280},{33489,39734},{33489,36786},{33489,3333},{35453,4564},{33489,26805},{33489,28054},{33489,35069},{35453,14201},{33489,20334},{35453,22512},{35453,10159},{33489,32512},{35453,5880},{33489,6832},{33489,12687},{35453,35557},{35453,14352},{35453,2253},{33489,32211},{35453,11986},{33489,14816},{35453,39331},{35453,31531},{33489,38389},{33489,18691},{35453,5912},{33489,35547},{35453,6832},{33489,12008},{33489,22375},{33489,8158},{33489,39796},{35453,18071},{33489,37302},{33489,14201},{33489,21143},{33489,22512},{33489,23663},{33489,2957},{35453,11528},{35453,7957},{33489,25079},{35453,33141},{35453,22688},{35453,3819},{33489,19316},{35453,32922},{35453,14749},{33489,32935},{35453,33012},{33489,14741},{33489,7021},{33489,5883},{33489,37393},{33489,20125},{33489,18071},{35453,11914},{33489,1812},{33489,10587},{35453,14589},{35453,21670},{35453,13079},{33489,5231},{35453,30580},{35453,6224},{35453,27505},{35453,13192},{33489,27613},{35453,29908},{35453,6218},{35453,25888},{33489,32181},{33489,33210},{33489,37531},{35453,837},{33489,12164},{33489,603},{35453,27912},{33489,22311},{33489,27882},{35453,39734},{35453,14508},{33489,6563},{35453,21506},{35453,34158},{35453,10587},{33489,837},{33489,21670},{33489,6761},{33489,2439},{33489,15645},{33489,4033},{35453,19329},{33489,37379},{33489,27505},{33489,9889},{35453,4352},{33489,5912},{33489,3418},{33489,38587},{33489,932},{33489,14474},{35453,31060},{33489,9707},{33489,14508},{35453,2819},{35453,35150},{35453,23663},{35453,38587},{35453,6673},{35453,32050},{35453,28883},{33489,2590},{35453,37302},{33489,6134},{33489,17849},{35453,13731},{35453,22809},{33489,35150},{35453,10279},{33489,24252},{33489,20832},{35453,25302},{35453,25529},{33489,31323},{35453,3418},{35453,13084},{35453,32521},{35453,32211},{33489,32959},{35453,7234},{35453,2957},{33489,34229},{33489,16813},{35453,37531}
        });
    }
}
