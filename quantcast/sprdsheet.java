import java.io.File;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;
import java.util.LinkedHashSet;

// the main spreadsheet class
public class Solution {
    
    // create two integers, defining the width and height of the spreadsheet (n,m)
	private int n;
	private int m;
    
    // create a two-dimensional array of cells as a spreadsheet
    Sheet[][] sheet_cells;
	public class Sheet{
		boolean nowEvaluate;
		boolean isEvaluated;
        Double value;
		String content;
		public Sheet(String content){
			this.content = content;
			this.nowEvaluate = false;
			this.isEvaluated = false;
		}
	}

	public static void main(String[] args){
        try{
            Solution spreadSheet = new Solution();
		    populate(spreadSheet);
            
		    for (int i = 0; i < spreadSheet.n; i++) {
                for (int j = 0; j < spreadSheet.m; j++) {
                    spreadSheet.evaluate(spreadSheet.sheet_cells[i][j],null);
                }
            }
        // output formatting: one output per line, in order A1,A2 ... A<n>; B1, B2 ... B<n>
            for (int i = 0; i < spreadSheet.n; i++) {
                for (int j = 0; j < spreadSheet.m; j++) {
                    if(i==spreadSheet.n-1 && j==spreadSheet.m-1)
                        System.out.printf("%.5f", spreadSheet.sheet_cells[i][j].value);
                    else
                        System.out.printf("%.5f%n", spreadSheet.sheet_cells[i][j].value);
                }
            }
        }
        // detect cyclic dependencies in the input data:
        catch(Exception e){
            System.out.println("Error: Circular dependency!");
        }
	}

	// main method "evaluate": evaluate a cell's value according to the expression
	private Double evaluate(Sheet sheet,Set<Sheet> evaluateStack) {
		if(evaluateStack == null){
            evaluateStack = new LinkedHashSet<Sheet>();
		}
		// check if cell's value is evaluated, if true, return the outcome
        if(sheet.isEvaluated){
        }
        // if not, calculate the value
        else if(!sheet.isEvaluated && !evaluateStack.contains(sheet))
		{
			evaluateStack.add(sheet);
            // get operands by splitting input string with " "
			String[] blocks = sheet.content.split(" ");
	        Stack<Double> operands = new Stack<Double>();
            
		        for(int i=0;i<blocks.length;i++) {
		            String s = blocks[i];
                    
		            // define 4 usual operator expressions: +, -, *, /
		            if (s.equals("+")) operands.push(operands.pop() + operands.pop());
                    
                    else if (s.equals("-")){ 
		            	double a = operands.pop();
		               	double b = operands.pop();
		            	operands.push(b - a);
		            }
                    
		            else if (s.equals("*")) operands.push(operands.pop() * operands.pop());
		            
                    else if (s.equals("/")){
		            	double a = operands.pop();
		               	double b = operands.pop();
		            	operands.push(b / a);
		            } 

		            else if (isNumber(s)) operands.push(Double.parseDouble(s));
		            else {
		            	Sheet cell_c = getValue(s);
		            	operands.push(evaluate(cell_c,evaluateStack));
		            }
		        }
		        sheet.value = operands.pop();
		        sheet.isEvaluated = true;
		}
        // complete evaluation and return outcome
		return sheet.value;
	}
    
	// create helper method #1 "getValue" to get each cell's value as integer
	private Sheet getValue(String s) {
		try {
            int x = (int)s.charAt(0) % 65;
            int y = Integer.parseInt(s.substring(1,s.length()))-1;
            return sheet_cells[x][y];
		}
        catch (NumberFormatException e) {
			System.out.println("Format error occurred:" + s);
            System.exit(1);
			  }
		return null;
	}

	// create helper method #2 "isNumber" to see if input string can be numeric
	private static boolean isNumber(String s) {
        try {
            Double.parseDouble(s);
		    return true;
        }
		catch (NumberFormatException e) {
            return false;
	    }
	}

	// create helper method #3 "populate" to populate values into spreadsheet cells
    	private static void populate(Solution spreadSheet) {
			try
			{
			Scanner cells = new Scanner(System.in);	
			spreadSheet.sheet_cells= null;
			String[] blocks = null;
			int[] size = new int[2];
            
			if (cells.hasNextLine()) {
				blocks = cells.nextLine().split(" ");
                // check if the number of cells is valid
				if (blocks.length != 2) {
					throw new IllegalArgumentException("Invalid number of cells!");
				} else {
					for (int i = 0; i < blocks.length; i++)
						size[i] = Integer.parseInt(blocks[i]);
					spreadSheet.sheet_cells = new Sheet[size[1]][size[0]];
					spreadSheet.m = size[0];
					spreadSheet.n = size[1];
				}
			}

			int row = 0, col = 0, count=0;
			while (cells.hasNextLine()) {
				String line = cells.nextLine();
				if (line.isEmpty())
					break;
				spreadSheet.sheet_cells[row][col] = spreadSheet.new Sheet(line);
					count ++;
				col ++;
				if(col == spreadSheet.m){
					col = 0;
					row ++;
				}
			}
			if (count != size[0]*size[1])
				throw new IllegalArgumentException("Invalid number of cells!");
			}
			catch(Exception e){
		    	System.out.println("Error occurred!");
		    	System.exit(1);
		    }
		}
    
}

