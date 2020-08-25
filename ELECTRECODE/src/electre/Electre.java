package electre;

import java.util.*;

public class Electre {
	double matrixDecision [][];
	double matrixNorm [][];
	double matrixWeight [][];
	double weight[] = {(double)1/11,(double)1/11,(double)1/11,(double)1/11,(double)1/11,(double)1/11,(double)1/11,(double)1/11,(double)1/11,(double)1/11,(double)1/11};
	double matrixWeightNorm [][];
	double matrixConcordance[][];
	double matrixDiscordance[][];
	int concordanceMatrix [][];
	int discordanceMatrix [][];
	int aggregateDominantMatrix [][];
	int sumCol [];
	int sumRow [];

	
	
	public Electre(){
		
	}
	 
	public double[][] data() {
		/*double Data1 [][]= {{100, 35, 55},
							{115, 34, 65},
							{90, 40, 52},
							{110, 36, 60}};*/
		double Data [][] = {{28,	28,		2.060241,	4, 	2.441176, 	28, 	2.75, 		0.0, 		0.065574, 	0.901639, 	0.067797},
							{3, 	10, 	2.076923, 	3, 	3.25, 		6, 		4.333333, 	0.0, 		0.076923, 	1.230769, 	0.407407},
							{37, 	114, 	1.985612, 	4, 	6.619048, 	41, 	34.75, 		0.0, 		0.045455, 	0.734848, 	0.177966},
							{10, 	21, 	2.341463,	3, 	4.555555,	10, 	13.666667, 	0.0,		0.814815, 	0.740741, 	0.444444},
							{19, 	19, 	1.136364,	2, 	5.5,		19,		11.0,		0.090909,	0.590909,	0.136364,	0.930233},
							{29, 	103,	3.180556,	6,	3.512195,	29,		24.0,		0.020979,	0.65035,	0.825175,	0.325714},
							{59, 	59,		1.016667,	2,	30.0,		59,		30.0,		0.083333,	0.016667,	0.016667,	0.909091},
							{1, 	54,		3.710526,	5,	3.304348,	28,		15.2,		0.0,		0.605263,	0.986826,	0.418605},
							{12, 	11,		1.565217,	3,	2.3,		12,		2.0,		0.120526,	0.789474,	1.052632,	0.5},
							{2,		2,		1.0,		1,	2.0,		2,		2.0,		1.0,		0.0,		0.0,		0.0},
							{2,		10,		3.285714,	5,	2.333333,	4,		4.2,		0.058824,	0.0,		0.1,		0.3464154},
							{2,		2,		1.0,		1,	2.0,		2,		2.0,		1.0,		0.0,		0.0,		0.0},
							{6,		8,		1.333333,	2,	4.5,		6,		4.5,		0.0,		0.0,		0.870968,	0.357143},
							{92,	101,	1.12,		3,	20.833333,	111,	41.666667,	0.007634,	0.312977,	0.877863,	0.590747},
							{52,	68,		1.351648,	3,	18.2,		71,		30.333333,	0.005556,	0.188889,	2.25,		0.264973},
							{3,		7,		2.2,		3,	2.5,		5,		3.333333,	0.0,		0.454545,	1.636364,	0.307692},
							{8, 	18,		3.387097,	6,	2.214286,	8,		5.166667,	0.0,		0.16129,	1.451613,	0.285714},
							{3, 	3,		1.25,		2,	2.0,		3,		2.0,		0.25,		0.25,		0.25,		0.875},
							{17,	27,		1.433333,	2,	7.5,		17,		15.0,		0.133333,	0.5,		0.433333,	0.59375},
							{2,		2,		1.0,		1,	2.0,		2,		2.0,		0.0,		0.666667,	0.3333333,	0.5},
							{8,		170,	3.504464,	7,	4.148148,	20,		32.0,		0.0,		0.080717,	0.96861,	0.205882},
							{4,		12,		1.733333,	2,	5.0,		10,		7.5,		0.142857,	0.214286,	0.785714,	0.266667},
							{8,		8,		1.0,		1,	29.0,		29,		29.0,		0.068966,	1.034483,	2.413793,	0.44},
							{3, 	11,		1.785714,	2,	3.5,		5,		7.0,		0.0,		0.0,		0.785714,	0.0},
							{8,		794,	4.309329,	9,	5.605505,	96,		135.777778,	0.0,		0.069431,	2.853423,	0.453656},
							{67,	79,		1.373737,	4,	12.375,		79,		24.75,		0.020408,	0.306122,	0.918367,	0.536082},
							{5,		33,		2.585366,	4,	4.555556,	10,		10.25,		0.056604,	0.0,		1.018868,	0.298701},
							{48,	126,	1.33871,	2,	18.6,		246,	186.0,		0.0,		0.010929,	2.278689,	0.291419},
							{9,		77,		2.139785,	3,	5.470588,	20,		31.0,		0.0,		0.032258,	0.967742,	0.391892},
							{1,		30,		3.051282,	4,	3.9,		11,		9.75,		0.025641,	0.0,		3.512821,	0.048611},
							{2, 	11,		2.117647,	3,	4.25,		7,		5.666667,	0.04,		1.04,		0.88,		0.12},
							{175,	130,	1.884615,	4,	2.771574,	175,	136.5,		0.0,		0.555205,	2.413249,	0.070474},
							{34,	51,		1.86,		9,	7.5,		220,	33.333333,	0.00365,	0.313869,	2.211679,	0.296167},
							{14,	14,		1.066667,	2,	7.5,		14,		7.5,		0.0,		0.2,		0.066667,	0.97561},
							{4,		4,		1.0,        1,	4.0,		4,		4.0,		0.0,		2.5,		0.0,		1.0},
							{14,	76,		1.842697,	2,	6.357143,	17,		44.5,		0.078652,	0.078652,	0.842697,	0.166667},
							{4,		6,		1.75, 		3,	2.666667,	4,		2.666667,	0.0,		0.333333,	0.555556,	0.5},
							{7,		10,		1.133333,	2,	15.0,		26,		15.0,		0.0,		0.0,		1.741935,	0.298701},
							{7,		25,		1.941176,	3,	4.25,		9,		11.333333,	0.0,		0.235294,	0.882353,	0.577465},
							{1,		1549,	10.096663,	16,	4.159184,	51,		127.375,	0.378007,	0.0,		0.999509,	4.91},
							{8,		117,	5.030928,	10,	1.69186,	13,		29.1,		0.022026,	0.054983,	0.989691,	0.102804},
							{7,		25,		1.140541,	3,	30.833333,	162,	61.666667,	0.0,		0.0,		1.741935,	0.298701},
							{7,		8,		1.068966,	2,	14.5,		27,		14.5,		0.0,		0.162996,	1.762115,	0.113082},
							{4,		34,		2.354839,	4,	7.75,		25,		15.5,		0.10303,	0.794118,	2.558824,	0.198157},
							{3,		131,	4.418182,	6,	4.714286,	19,		27.5,		0.010101,	0.210884,	1.55102,	0.161765},
							{14,	38,		2.04902,	6,	3.923077,	52,		17.0,		0.0,		0.175758,	0.987879,	0.151042},
							{1,		1,		1.5,		2,	1.0,		1,		1.0,		0.02439,	0.414141,	0.909091,	0.479769},
							{12,	16,		1.205128,	2,	7.8,		31,		19.5,		0.153846,	0.065574,	0.5,		0.5},
							{5,		6,		1.777778,	4,	2.25,		5,		2.25,		0.291667,	0.076923,	2.073171,	0.413793},
							{14,	16,		1.434783,	3,	2.875,		14,		7.666667,	0.0,		0.045455,	2.538462,	0.459016}};
		return Data;
			
	}
	
	public void initData(double matrixX [][]){
				
		matrixDecision= new double[matrixX.length][matrixX[0].length];
		
		for(int i=0; i< matrixX.length; i++) {
			for(int j=0; j<matrixX[0].length;j++) {
				matrixDecision[i][j]=matrixX[i][j]; 
			}
		}
		
	}
	

	
	public void normalizeData(){
        
        double divisor=0;
        double sum;
        int row = matrixDecision.length;
        int col = matrixDecision[0].length;    
        
        matrixNorm = new double [matrixDecision.length][matrixDecision[0].length];
        
        for(int c=0; c<col; c++){
        	sum = 0;
            for(int r=0; r<row; r++){
                sum = sum + Math.pow(matrixDecision[r][c], 2.0) ;
            }
            divisor = Math.sqrt(sum);
         
            for(int r=0; r<row; r++){
            	matrixNorm[r][c] = matrixDecision[r][c]/divisor;
            }
        }

                
 
    }
	public void initWeight() {
		matrixWeight = new double[matrixDecision[0].length][matrixDecision[0].length];
    
        for(int i=0; i<matrixWeight.length; i++){
            for(int j=0; j<matrixWeight.length; j++){
                if(i==j){
                	
                    matrixWeight[i][j] = (double)1/11;
                    
                }
                else{
                    matrixWeight[i][j] = 0.0;
                }
            }
        }
		
	} 
	public void weightNormalisation(){
       
        matrixWeightNorm = new double[matrixDecision.length][matrixDecision[0].length];
        
        for(int i=0; i<matrixNorm.length; i++){
            for(int j=0; j<matrixNorm[i].length; j++){
            	matrixWeightNorm[i][j] = 0.0;
            }
        }
        
        for(int i=0; i<matrixNorm.length; i++){
            for(int j=0; j<matrixNorm[i].length; j++){
               matrixWeightNorm[i][j] = matrixNorm[i][j]*weight[j];
                
            }
        }
    }
	
	public void concordance() {
		matrixConcordance = new double [matrixWeightNorm.length][matrixWeightNorm.length];
		
		for (int j = 0; j < matrixWeightNorm.length; j++) {
			for (int i = 0; i < matrixWeightNorm.length; i++) {
				if (i == j) {
					matrixConcordance[i][j] = 0;
				} else {
					for (int k = 0; k < matrixWeightNorm[0].length; k++) {
						if (matrixWeightNorm[i][k] >= matrixWeightNorm[j][k]) {
							matrixConcordance[i][j] += weight[k];
						}
					}
				}
			}
		}
		
	}
	public void discordance() {
		matrixDiscordance = new double [matrixWeightNorm.length][matrixWeightNorm.length];
		
		double[]   DTemp = new double[matrixWeightNorm[0].length];

				
		for (int j = 0; j < matrixWeightNorm.length; j++) {
			for (int i = 0; i < matrixWeightNorm.length; i++) {
				if (i == j) {
					matrixDiscordance[i][j] = 0;
				} else {
					for (int k = 0; k < matrixWeightNorm[0].length; k++) {
						DTemp[k] = (matrixWeightNorm[j][k] - matrixWeightNorm[i][k]);
						
					}
					double max=DTemp[0];
					double min = DTemp[0];;
					for (int k = 0; k < DTemp.length; k++) {
						if(DTemp[k] > max) {
							max=DTemp[k];
						}
						if(DTemp[k] < min) {
							min=DTemp[k];
						}
						
					}
					if(min<0) {
						min*=-1;
					}
					if(max<0) {
						max*=-1;
					}
					if(max!=0) {
						matrixDiscordance[i][j] = min/max;
					}else {
						matrixDiscordance[i][j] = 0;
					}
				}
			}
		}
		
	}
	
	public double cBar() {
		double sum=0;
		for(int i=0; i<matrixConcordance.length; i++) {
			for(int j=0; j<matrixConcordance.length; j++) {
				sum+=matrixConcordance[i][j];
			}
		}
		
		double cBar=sum/(matrixConcordance.length*(matrixConcordance.length-1));
		return cBar;
	}
	public double dBar() {
		double sum=0;
		for(int i=0; i<matrixDiscordance.length; i++) {
			for(int j=0; j<matrixDiscordance.length; j++) {
				sum+=matrixDiscordance[i][j];
				//System.out.println(sum);
			}
		}
		
		double dBar=sum/(matrixDiscordance.length*(matrixDiscordance.length-1));
		return dBar;
	}
	
	public void concordanceCalc() {
		concordanceMatrix = new int [matrixConcordance.length][matrixConcordance.length];
		double cBar=cBar();
		for(int i=0; i<matrixConcordance.length;i++) {
			for(int j=0;j<matrixConcordance.length;j++) {
				if(matrixConcordance[i][j]>cBar) {
					concordanceMatrix[i][j]=1;
				} else {
					concordanceMatrix[i][j]=0;
				}
			}
		}
		
	} 
	
	public void discordanceCalc() {
		discordanceMatrix = new int [matrixDiscordance.length][matrixDiscordance.length];
		double dBar=dBar();
		for(int i=0; i<matrixDiscordance.length;i++) {
			for(int j=0;j<matrixDiscordance.length;j++) {
				if(matrixDiscordance[i][j]>dBar) {
					discordanceMatrix[i][j]=1;
				} else {
					discordanceMatrix[i][j]=0;
				}
			}
		}
		
	}	
	
	public void aggregateDominantMatrix() {
		aggregateDominantMatrix = new int[concordanceMatrix.length][concordanceMatrix.length];
		for(int i=0; i<matrixConcordance.length;i++) {
			for(int j=0;j<matrixConcordance.length;j++) {
				aggregateDominantMatrix[i][j] = concordanceMatrix[i][j]*discordanceMatrix[i][j];
			}
		}
	}
	
	public void sumColRow() {
		sumCol = new int [aggregateDominantMatrix.length];
		sumRow= new int [aggregateDominantMatrix.length];
	
		for(int i=0; i<aggregateDominantMatrix.length;i++) {
			int sum1 =0;
			int sum2 =0;
			for(int j=0;j<aggregateDominantMatrix.length;j++) {
				//row
				sum1+=  aggregateDominantMatrix[i][j];
				//col
				sum2+=  aggregateDominantMatrix[j][i];
			}
			sumRow[i]=sum1;
			sumCol[i]=sum2;
		}
		
	}

	
	public void printNormMatrix() {
		for(int i=0; i<matrixNorm.length; i++){
            for(int j=0; j<matrixNorm[i].length; j++){
            	System.out.print(matrixNorm[i][j]+"	");
            }
            System.out.println();
        }
	}
	public void print2DMatrix(double[][] Matrix) {
		for(int i=0; i<Matrix.length; i++){
            for(int j=0; j<Matrix[i].length; j++){
            	System.out.print(Matrix[i][j]+"	");
            }
            System.out.println();
        }
	}
	public void print2DMatrix(int[][] Matrix) {
		for(int i=0; i<Matrix.length; i++){
            for(int j=0; j<Matrix[i].length; j++){
            	System.out.print(Matrix[i][j]+"	");
            }
            System.out.println();
        }
	}
	
	public void print1DMatrix(int[] Matrix) {
		for(int i=0; i<Matrix.length; i++){            
            	System.out.print(Matrix[i]+"	");
        }
		System.out.println();
	}
	
	public void printRankedMatrix(int[] Matrix) {
				
		Pair[] indexArray = new Pair[Matrix.length];
		
		for(int i=0; i<Matrix.length; i++){  
			indexArray[i]= new Pair(i+1, Matrix[i]);
		}
		
		Arrays.sort(indexArray);
		System.out.println("Ranking:");
		System.out.println();
		
		for(int i=0; i<Matrix.length; i++){  
			System.out.println("Ontology: "+indexArray[i].index +"	"+ indexArray[i].value);
		}
	}
	
	
	
	public class Pair implements Comparable<Pair> {
	    public final int index;
	    public final int value;

	    public Pair(int index, int value) {
	        this.index = index;
	        this.value = value;
	    }

	    @Override
	    public int compareTo(Pair other) {
	        //multiplied to -1 for descending order
	        return -1 * Integer.valueOf(this.value).compareTo(other.value);
	    }
	    
	 
	}
	
	//
	//

}
