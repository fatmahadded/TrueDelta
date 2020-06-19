package ManagedBeans.AM;

import java.util.Date;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import Entities.AssetManager;
import interfaces.IUserLocalService;
import interfaces.IUserRemoteService;
import services.UserService;
import utils.FileUtils;

import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.http.Part;
import java.io.File;
import java.io.FileOutputStream;

import java.io.InputStream;
import java.io.OutputStream;


@ManagedBean(name="testBean")
@javax.faces.bean.SessionScoped
public class testBean {
	
	@EJB
	IUserRemoteService userServiceLocal;
	
	private String firstName;

	private String lastName;

	private String password;

	private Date date;
	
	private String image;
	
	private String cv;
	
	private Part imageFile;
	
	private Part cvFile;
	
	private String message;
	
	private Boolean termsAndConditions;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public String getImage() throws IOException  {
		return image;
	}

	public String getCv() {
		return cv;
	}
	public void setImage(String image) {
		this.image = image;
	}

	public void setCv(String cv) {
		this.cv = cv;
	}
	public Part getImageFile() {
		return imageFile;
	}

	public void setImageFile(Part imageFile) {
		this.imageFile = imageFile;
	}

	public Part getCvFile() {
		return cvFile;
	}

	public void setCvFile(Part cvFile) {
		this.cvFile = cvFile;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	public Boolean getTermsAndConditions() {
		return termsAndConditions;
	}

	public void setTermsAndConditions(Boolean termsAndConditions) {
		this.termsAndConditions = termsAndConditions;
	}

	public String doRegister() throws IOException {
		this.uploadCv();
		this.uploadFile();
		
		String navigateTo = "";
		AssetManager user = new AssetManager();
		user.setUsername(firstName);
		user.setLastname(lastName);
		user.setPassword(password);
		user.setDateSortie(date);
		user.setCv(cv);
		user.setImage(image);
		userServiceLocal.create(user);
		System.out.println("ok register");
		navigateTo = "/pages/user/login?faces-redirect=true";

		return navigateTo;
	}
	public String uploadFile() throws IOException {
		InputStream inputStream = null;
		OutputStream outputStream = null;
		/*FacesContext context = FacesContext.getCurrentInstance();
		ServletContext servletContext = (ServletContext) context.getExternalContext().getContext();
		String path = servletContext.getRealPath("");*/
		boolean imageFileSuccess = false;
		if (imageFile.getSize() > 0) {
			String fileName = FileUtils.getFileNameFromPart(imageFile);
			System.out.print("image" + fileName);
			this.image = fileName;
			/**
			 * destination where the file will be uploaded
			 */
			File outputFile = new File("C:"+File.separator+"Products" + File.separator + "images" + File.separator + fileName);
			inputStream = imageFile.getInputStream();
			outputStream = new FileOutputStream(outputFile);
			byte[] buffer = new byte[8 * 1024];
			int bytesRead = 0;
			while ((bytesRead = inputStream.read(buffer)) != -1) {
				outputStream.write(buffer, 0, bytesRead);
			}
			if (outputStream != null) {
				outputStream.close();
			}
			if (inputStream != null) {
				inputStream.close();
			}
			imageFileSuccess = true;
		}
		/*if (imageFileSuccess || cvFileSuccess) {
			System.out.println("File uploaded to : " + path);
			setMessage("File successfully uploaded to " + path);
		} else {
			setMessage("Error, select atleast one file!");
		}*/

		return null;
	}
	public String uploadCv() throws IOException {
		InputStream inputStream = null;
		OutputStream outputStream = null;
		
		boolean cvFileSuccess = false;
		if (cvFile.getSize() > 0) {
			String fileName = FileUtils.getFileNameFromPart(cvFile);
			System.out.print("cv" + fileName);
			this.cv = fileName;
			File outputFile = new File("C:"+File.separator+"Products" + File.separator + "cv" + File.separator + fileName);
			inputStream = cvFile.getInputStream();
			outputStream = new FileOutputStream(outputFile);
			byte[] buffer = new byte[8 * 1024];
			int bytesRead = 0;
			while ((bytesRead = inputStream.read(buffer)) != -1) {
				outputStream.write(buffer, 0, bytesRead);
			}
			if (outputStream != null) {
				outputStream.close();
			}
			if (inputStream != null) {
				inputStream.close();
			}
			cvFileSuccess = true;
		}

		return null;
	}
}