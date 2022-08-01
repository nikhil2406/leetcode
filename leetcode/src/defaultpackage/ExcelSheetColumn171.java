package defaultpackage;

public class ExcelSheetColumn171 {

	public static void main(String[] args) {
		String columnName = "Z";
		int ret = titleToNumber(columnName);
		System.out.println("column number = " + ret);

	}
	 static int titleToNumber(String columnTitle) {
		 int num = 0;
		 int power = 0;
		 for(int i = columnTitle.length()-1; i >= 0; i--) {
			 int offset = (columnTitle.charAt(i) - 'A') + 1;
			 num = num + (offset)* (int)Math.pow(26, power);
			 power++;
		 }
		 return num;
	 }

}
