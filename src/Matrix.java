public class Matrix {
    int m; //number of rows
    int n; //number of columns
    double values[][];
    public Matrix(int[][] values){
        m = values.length;
        n = values[0].length;
        this.values = new double[m][n];
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                this.values[i][j] = values[i][j];
            }
        }
    }
    public Matrix(double[][] values){
        m = values.length;
        n = values[0].length;
        this.values = new double[m][n];
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                this.values[i][j] = values[i][j];
            }
        }
    }
    public Matrix(int m, int n, int x){
        this.m = m;
        this.n = n;
        this.values = new double[m][n];
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                this.values[i][j] = x;
            }
        }
    }
    public String toString(){
        String rtn = "";
        for(double[] i:values){
            for(double j:i){
                rtn = String.format("%s %5.2f", rtn, j);
            }
            rtn = String.format("%s\n", rtn);
        }
        return rtn;
    }
    public double get(int n, int m){
        return values[n][m];
    }
    public Matrix inverse() {
        if (m == n) {// CHECK DETERMINENT TOO !!!
            Matrix m1 = new Matrix(this.m, this.n * 2, 0);
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    m1.values[i][j] = this.values[i][j];
                }
            }
            for (int i = 0; i < m; i++) {
                for (int j = n; j < n * 2; j++) {
                    if (j - n == i) {
                        m1.values[i][j] = 1;
                    }
                }
            }
            for(int i = 0;i<m;i++){
                double c =  m1.values[i][i];
                //divide each row by i, i
                for(int j = 0;j<2*n;j++){
                    m1.values[i][j] = m1.values[i][j] / c;
                }

                //subtract the rest of the rows
                for(int k = i+1;k<m;k++){
                    for(int j = n*2-1;j>=0;j--){
                        m1.values[k][j] = m1.values[k][j] - m1.values[i][j] * m1.values[k][i];
                    }
                }
            }

            for (int i = m-1; i >= 0; i--) {
                for(int k = i-1;k>=0;k--){
                    for(int j = n*2-1;j>=0;j--){
                        m1.values[k][j] = m1.values[k][j] - m1.values[i][j] * (m1.values[k][i]/ m1.values[i][i]);
                    }
                }
            }

            Matrix m2 = new Matrix(this.m, this.n, 0);
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    m2.values[i][j] = m1.values[i][j+n];
                }
            }
            return m2;
        }
        return null;
    }
    
}
