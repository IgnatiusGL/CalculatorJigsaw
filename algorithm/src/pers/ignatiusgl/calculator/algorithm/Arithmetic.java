package pers.ignatiusgl.calculator.algorithm;

/**
 * Used to calculate some basic operations
 * How to use:
 *      1.Sse the setFormula(String formula) to set the formula
 *      2.Sse the getResult() to get the result(String) of calculate.
 *        If your formula is can't calculate,you will get a "Error" String.
 *
 * Create in October.9th.2018
 * Last change in October.9th.2018 by IgnatiusGL
 *
 * @author IgnatiusGL
 */
public class Arithmetic {
    //the arithmetic formula
    private String formula;

    public Arithmetic(){

    }

    /**
     * Set the formula that used operations
     * @param formula require to calculate
     */
    public void setFormula(String formula){
        this.formula = formula;
    }

    /**
     * Get the result of the calculate
     * Return the "Error" String if the formula can't calculate
     * @return the result of the calculate
     */
    public String getResult() {
        try {
            double sum = 0;
            int p=0,q=0;
            while(q<formula.length()) {
                while (q < formula.length() && formula.charAt(q) != '+' && formula.charAt(q) != '-')
                    q++;
                double tmp = 1;
                int tp, tq;
                tp = tq = p;
                while (tq < q) {
                    while (tq < q && formula.charAt(tq) != '*' && formula.charAt(tq) != '/')
                        tq++;
                    if (formula.charAt(tp) == '/')
                        tmp /= Double.valueOf(formula.substring(tp+1, tq));
                    else if(formula.charAt(tp) == '*')
                        tmp *= Double.valueOf(formula.substring(tp+1, tq));
                    else
                        tmp *= Double.valueOf(formula.substring(tp, tq));
                    tp = tq;
                    tq++;
                }
                if (formula.charAt(p) == '-')
                    sum -= tmp;
                else
                    sum += tmp;
                p = q;
                q++;
            }
            String  result = sum + "";
            //find the superfluous zero and point
            char[] t = result.toCharArray();
            for(int i=t.length-1;i>=0;i--){
                if(t[i] == '.'){
                    for(int j =t.length-1;j>=i;j--){
                        if(t[j] != '0'){
                            result = result.substring(0,j+1);
                            break;
                        }
                    }
                    if(result.length() == i+1){
                        result = result.substring(0,i);
                    }
                    break;
                }
            }
            return result;
        }catch (Exception e) {
            e.printStackTrace();
            return "Error";
        }
    }
}
