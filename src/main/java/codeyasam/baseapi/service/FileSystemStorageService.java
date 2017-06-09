package codeyasam.baseapi.service;

import java.io.FileOutputStream;
import java.util.Base64;
import java.util.UUID;

import org.springframework.stereotype.Service;

import codeyasam.baseapi.config.StorageProperties;
import codeyasam.baseapi.exception.StorageException;

@Service
public class FileSystemStorageService {
	
	private StorageProperties storageProperties;
	
	public FileSystemStorageService(StorageProperties storageProperties) {
		this.storageProperties = storageProperties;
	}
	
	public String storeBase64encodedImage(String encodedString) {
		try {
			UUID uuid = UUID.randomUUID();
			String filePath = storageProperties.getRootLocation() + uuid.toString();
			FileOutputStream fos = new FileOutputStream(filePath);
			byte[] imageByteArray = Base64.getDecoder().decode(encodedString);
			fos.write(imageByteArray);
			fos.close();
			return filePath;
		} catch (Exception e) {
			throw new StorageException("Failed to store file", e);
		}
	}
}
