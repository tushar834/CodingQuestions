import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SQLContext;
import org.apache.spark.sql.functions;

/**
 * @author lenovo
 *
 */
public class HelloWorld {
	public HelloWorld() {
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
	org.apache.spark.sql.SparkSession spark=org.apache.spark.sql.SparkSession.builder().appName("hello").config("spark.master", "local").getOrCreate();
	
		
		SQLContext sqlContext = new org.apache.spark.sql.SQLContext(spark);
			
		Dataset<Row> logData = spark.read().option("header","true").format("com.databricks.spark.csv")
				.csv("C:\\Users\\lenovo\\Downloads\\new.csv");
		
		
		Dataset<Row> logData1 = spark.read().option("header","true").format("com.databricks.spark.csv").csv("C:\\Users\\lenovo\\Downloads\\new2.csv");
//		Exception in thread "main" java.lang.NoSuchMethodError: scala.Product.$init$(Lscala/Product;)V
//
		/* logData.createGlobalTempView("viewName"); */
		
		final Dataset<Row> allDataFamilyDf = logData1.withColumn("FamilySize",
			    functions.col("id").plus(functions.col("name")));
		
		allDataFamilyDf.show();
		
		
		logData1.filter("name=='tushar'").show();
		
		
		
		
		
		//1 df.show   ->	transformation lgake csv form(csv operation) 
		
		//2.join and other operation
		
		//3. phone and approach followed to integrate  (->standalone operation and integrated)
		
		/*
		 * logData.write().text("C:\\Users\\lenovo\\Downloads\\dumpfinal\new1.txt");
		 * 
		 * 
		 */
		
		logData.printSchema();
		
		logData.show();
		
		/* logData.select(col("")).show(); */
		
		sqlContext.registerDataFrameAsTable(logData,"new12");
		
		sqlContext.registerDataFrameAsTable(logData1,"new123");
		
		
		Dataset<Row> logData123=sqlContext.sql("select id,name from new12");
		
		Dataset<Row> logData1234=sqlContext.sql("select id,name from new123");
		
		logData1234.col("id").equalTo(logData1234.col("id"));
		
		logData123.show();
		
		
		
		
		
		
		
		logData123.registerTempTable("logData1234");
		logData1234.registerTempTable("dfprofile");
		
		//blog followed
		
		//https://stackoverflow.com/questions/40343625/joining-spark-dataframes-on-the-key
		

		Dataset<Row> logData12345=sqlContext.sql("SELECT * FROM  logData1234 INNER JOIN  dfprofile ON logData1234.id == dfprofile.id");
		
		
		Dataset<Row> logData4321=sqlContext.sql("SELECT * FROM  logData1234 LEFT JOIN  dfprofile ON logData1234.id == dfprofile.id");
		
		
		Dataset<Row> logData432=sqlContext.sql("SELECT * FROM  logData1234 RIGHT JOIN  dfprofile ON logData1234.id == dfprofile.id");
		
		Dataset<Row> logData43=sqlContext.sql("SELECT * FROM  logData1234 RIGHT OUTER JOIN  dfprofile ON logData1234.id == dfprofile.id");
		
		Dataset<Row> logData4=sqlContext.sql("SELECT * FROM  logData1234 LEFT OUTER JOIN  dfprofile ON logData1234.id == dfprofile.id");
		
		
		
		
		
		logData12345.show();
		
		logData4321.show();
		
		 logData43.show();
		 
		 logData4.show();
		
		
		
		
		
		
		
		
//						spark.show
		/*
		 * logData.createGlobalTempView("viewName1");
		 * 
		  spark.
		  sql("select * from viewName inner join viewName1 on viewName1.value=viewName.value"
		  );
		 
		
//		
	
		logData.show();
	
	/*
	 * Exception in thread "main" java.lang.NoClassDefFoundError:
	 * scala/Product$class
	 */
		
//	args=
//		
//		logData.show();
//		
//	SparkConf conf=new SparkConf().setAppName("line_count").setMaster("local");
//
//	JavaSparkContext ctx=new JavaSparkContext(conf);
//	
//	JavaRDD<String> textload=ctx.textFile("C:\\Users\\lenovo\\Downloads\\new.txt");
//	
//	String logdata="C:\\Users\\lenovo\\Downloads\\new.txt";
//	
//	
//	System.out.println(textload.count());


	}

}
