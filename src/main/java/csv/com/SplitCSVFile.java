package csv.com;

import java.io.*;

public class SplitCSVFile {

	public static void split() {

		long linesWritten = 0;
	    int  count = 1;
	    int  linesPerSplit = 20000;
	    
	    String inputFilePath  = "C:\\CSV_file\\5m-Sales-Records\\5m Sales Records.csv";
	    String outputFolderPath = "C:\\outputCSV_file";

	    try {
	        File inputFile = new File(inputFilePath);
	        InputStream inputFileStream = new BufferedInputStream(new FileInputStream(inputFile));
	        BufferedReader reader = new BufferedReader(new InputStreamReader(inputFileStream));

	        String line = reader.readLine();

	        String fileName = inputFile.getName();
	        String outfileName = outputFolderPath + "\\" + "SmallCSVFile";

	        while (line != null) {
	            File outFile = new File(outfileName + "_" + count + ".CSV");
	            Writer writer = new OutputStreamWriter(new FileOutputStream(outFile));

	            while (line != null && linesWritten < linesPerSplit) {
	                writer.write(line + System.lineSeparator());
	                line = reader.readLine();
	                linesWritten++;
	            }

	            writer.close();
	            linesWritten = 0;//next file
	            count++;//next file count
	        }

	        reader.close();
	        inputFile.delete();

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
		
	}

}
