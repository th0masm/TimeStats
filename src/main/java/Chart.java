package main.java;
import java.util.List;

public class Chart {

	private String name; 
	private List<Rider> riders;

	public Chart(List<Rider> r, String n) {
		riders = r;
		name=n;
	}

	public String getChart() {

		StringBuffer str = new StringBuffer();

		str.append("<script type=\"text/javascript\">\n//<![CDATA[\n"
				+ "jQuery(function () {\n"
				+ "jQuery('#container').highcharts({\n"
				+ "chart: {\n"
				+ "	zoomType: 'x',\n"
				+ " spacingRight: 20,\n"
				+ "	type: 'line',\n"
				+ "	marginRight: 40,\n"
				+ "	marginBottom: 50\n"
				+ "},\n"
				+ "title: {\n"
				+ "	text: '"+name+"',\n"
				+ "	x: -20\n"
				+ "},\n"
				+ "subtitle: {\n"
				+ "	text: 'Analyse tour par tour',\n"
				+ "	x: -20\n"
				+ "},\n"
				+ "xAxis: {\n"
				+ "	tickInterval:1,\n"
				+ "	labels : {\n"
				+ "	formatter: function() {\n"
				+ "		return this.value+1;\n"
				+ "		}\n"
				+ "}\n"
				+ "},\n"
				+ "yAxis: {\n"
				+ "	title: {\n"
				+ "		text: ''\n"
				+ "},\n"
				+ "plotLines: [{\n"
				+ "		width: 1,\n"
				+ "   	color: 'red'\n"
				+ "}],\n"
				+ "labels : {\n"
				+ "		formatter: function() {\n"
				+ "			var time=this.value+\'\';\n" 
				+ "			var timesplitted=time.split(\".\"); \n" 
				+ "			var mintemp = (timesplitted[0]/60)+''; \n" 
				+ "			var minmod = parseInt(timesplitted[0])%60; \n" 
				+ "			var min = mintemp.split(\",\");\n"
				+ "			if(minmod<10)\n"
				+ "				min = mintemp[0] +'\\'0'+ minmod;\n"
				+ "			else\n"
				+ "				min = mintemp[0] +'\\''+ minmod;\n"
				+ "			return min;\n"
				+ "		}\n"
				+ "},\n" 
				+ "},\n"
				+ "tooltip: {\n"
				+ "		formatter: function() {\n"
				+ "			var time=this.y+'';\n"
				+ "			var timesplitted=time.split(\".\");\n"
				+ "			var mintemp = (timesplitted[0]/60)+'';\n"
				+ "			var minmod = parseInt(timesplitted[0])%60;\n"
				+ "			var min = mintemp.split(\",\");\n"
				+ "   		if(minmod<10){\n"
				+ "       			min = mintemp[0] +'\\'0'+ minmod;\n"
				+ "					return 'Tour '+ (parseInt(this.x)+1) +': '+min+'.'+timesplitted[1];\n"
				+ "			} else {\n"
				+ "      			min = mintemp[0] +'\\''+ minmod;\n"
				+ "      			return 'Tour '+ (parseInt(this.x)+1) +': '+min+'.'+timesplitted[1];\n" 
				+ "			}\n" 
				+ "     }\n" 
				+ "},\n" 
				+ "legend: {\n" 
				+ "layout: 'vertical',\n"
				+ "align: 'right',\n" 
				+ "verticalAlign: 'top',\n"
				+ "x: -10,\n" 
				+ "y: 100,\n" 
				+ "borderWidth: 0\n" 
				+ "},\n"
				+ "series: [\n");
		str.append(getSeries());
		str.append("});\n }\n);\n //>\n </script>\n");
		str.append("<div id=\"container\" style=\"min-width: 620px; height: 500px; margin: 0 auto;\"></div>\n");
		return str.toString();

	}

	private String getSeries() {
		StringBuffer str = new StringBuffer();
		int j=0;
		for (Rider r : riders) {
			str.append("{\n" + "name: '" + r.getName() + "',\n" + "data: [\n");
			j++;
			int i=0;
			for (Time t : r.getTimes()) {
				str.append(t.convertToSec());
				i++;
				if(i<r.getTimes().size())
					str.append(",\n");
				
			}
			if(j<riders.size())
				str.append("]\n},");
			else
				str.append("]\n}\n]");


		}

		return str.toString();
	}

}
