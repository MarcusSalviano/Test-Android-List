package com.test.testlist;

public class Search {
    public boolean hasTypo(String param1, String param2) {
        if (param1.length() == param2.length()) {
            int changedCount = 0;
            for (int x = 0; x < param1.length(); x++) {
                if (param1.charAt(x) != param2.charAt(x)) {
                    changedCount++;
                }
            }

            if (changedCount > 1)
                return false;
        } else {
            if(Math.abs(param1.length()-param2.length()) > 1) {
                return false;
            }

            String paramB = param1;
            String paramS = param2;

            if(param1.length() < param2.length()) {
                paramB = param2;
                paramS = param1;
            }

            int changedCount = 0;
            int indexpParamS = 0;
            for(int x = 0; x < paramB.length(); x++) {
                if(changedCount == 0 && x == paramB.length()-1)
                    break;

                if(paramB.charAt(x) != paramS.charAt(indexpParamS)) {
                    changedCount++;
                } else {
                    indexpParamS++;
                }
            }

            if (changedCount > 1)
                return false;
        }

        return true;
    }
}
