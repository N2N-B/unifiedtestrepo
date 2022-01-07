package Common;

public class Attributes {

	public static class Login {
		public static String loginPageUrl = "loginUrl";
		public static String sheet_Name = "Sheet1";
		public static String testDataPath = System.getProperty("user.dir") + "/src/main/java/resources/TestData.xlsx";
	}

	public static class PersonalInformation {
		public static String selectProductUrl = "productsPageUrl";
		public static String imageFile = System.getProperty("user.dir") + "/src/main/java/resources/logo.png";
		public static String editXpath = "//img[@class='profile__image']";
		public static String saveXpath = "//*[contains(text(),'Save')]";
		public static String linkedIn_Name = "Anita";
		public static String fb_Name = "Aniya";
		public static String twitter_Name = "@tari";
		public static String backButton = "//*[contains(@src,'backbutton')]";
	}

	public static class Aspirational {
		public static String noOfSchools = "//li[contains(.,'1')]";
		public static String intakesXpath = "//li[contains(.,'Fall 2024')]";
		public static String degreeXpath = "//li[contains(.,'M.Sc')]";
		public static String $fieldOfStudyXpath = "//li[contains(.,'Computer Science Engineering')]";
		public static String $specializationXpath = "//li[contains(.,'Computing Systems')]";
		public static String $preferredRegionXpath = "//li[contains(.,'England')]";
		public static String $preferredGradSchoolXpath = "//li[contains(.,'Middlesex University London')]";
	}

	public static class Common {
		public static String fillTheReqField = "Please fill the required field";

	}

	public static class Ssctenth {
		public static String fileUpload = "F:\\KaniMozhi_Resume.pdf";
		public static String examBoardXpath = "//li[contains(.,'CBSE')]";
		public static String $start_Date = "29-12-2021";
		public static String $end_Date = "10-01-2022";
		public static String schoolXpath = "Jesuraja School";
		public static String uploadFileXpath = "//*[name()='path' and contains(@d,'M5')]";
		public static String gradeScale = "//li[contains(.,'10')]";

	}

	public static class PlusTwo {
		//public static String fileUpload = System.getProperty("user.dir") + "/src/main/java/resources/sample.pdf";
		public static String fileUpload = "F:\\KaniMozhi_Resume.pdf";
		public static String examBoardXpath = "//li[contains(.,'CBSE')]";
		public static String $start_Date = "29-12-2021";
		public static String $end_Date = "10-01-2022";
		public static String schoolXpath = "Amirta Vidhyalaya";
		public static String $gradeScaleXpath = "//li[contains(.,'10')]";
		public static String $cgpa = "8.9";
		public static String uploadFileXpath = "//*[@type='file']/following::img";

	}

	public static class Diploma {
		public static String collegeXpath = "//li[contains(.,'Andhra University')]";
		public static String universityXpath = "//li[contains(.,'Tezpur University, Tezpur')]";
		public static String diplomaXpath = "//li[contains(.,'Post Graduate Diploma')]";
		public static String fieldOfStudyXpath = "//li[contains(.,'Information and Communication Technology')]";
		public static String $start_Date = "29-12-2021";
		public static String $end_Date = "10-01-2022";
		public static String $gradeScaleXpath = "//li[contains(.,'10')]";
		public static String $cgpa = "7.5";
	}

	public static class UnderGraduate {
		public static String collegeXpath = "//li[contains(.,'Chalapathi Institute of Engineering and Technology')]";
		public static String universityXpath = "//li[contains(.,'Assam University, Silchar')]";
		public static String degreeXpath = "//li[contains(.,'BSC')]";

		public static String fieldOfStudyXpath = "//li[contains(.,'Computer Science and Engineering')]";
		public static String $start_Date = "29-12-2021";
		public static String $end_Date = "10-01-2022";
		public static String $gradeScaleXpath = "//li[contains(.,'10')]";
		public static String $cgpa = "7.5";

	}

	public static class PostGraduate {
		public static String collegeListXpath = "//li[contains(.,'Aditya Engineering College')]";
		public static String universityListXpath = "//li[contains(.,'Tezpur University, Tezpur')]";
		public static String degreeListXpath = "//li[contains(.,'MBA')]";
		public static String courseListXpath = "//li[contains(.,'Business Management')]";
		public static String start_Date = "30-12-2021";
		public static String end_Date = "30-12-2023";
		public static String gradeListXpath = "//li[contains(.,'10')]";
		public static String $cgpa = "7.5";

	}

}
