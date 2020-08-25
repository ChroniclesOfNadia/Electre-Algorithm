package electre;

public class Main {
	public static void main( String [] args) {
		Electre electre = new Electre();
		
		electre.initData(electre.data());
		electre.normalizeData();
		//electre.printNormMatrix();
		electre.initWeight();
		//electre.print2DMatrix(electre.matrixWeight);
		electre.weightNormalisation();
		//electre.print2DMatrix(electre.matrixWeightNorm);
		electre.concordance();
		//electre.print2DMatrix(electre.matrixConcordance);
		electre.discordance();
		//electre.print2DMatrix(electre.matrixDiscordance);
		//System.out.println(electre.cBar());
		//System.out.println(electre.dBar());
		electre.concordanceCalc();
		//electre.print2DMatrix(electre.concordanceMatrix);
		electre.discordanceCalc();
		//electre.print2DMatrix(electre.discordanceMatrix);
		electre.aggregateDominantMatrix();
		//electre.print2DMatrix(electre.aggregateDominantMatrix);
		electre.sumColRow();
		//System.out.println("Row: ");
		//electre.print1DMatrix(electre.sumRow);
		//System.out.println("Col: ");
		//electre.print1DMatrix(electre.sumCol);
		System.out.println("Row: ");
		electre.printRankedMatrix(electre.sumRow);
		//System.out.println("Col: ");
		//electre.printRankedMatrix(electre.sumCol);
		
	}

}
