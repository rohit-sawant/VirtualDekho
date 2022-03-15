package com.example.herokudemo.service;

import java.io.ByteArrayInputStream;
import java.util.List;

import com.example.herokudemo.model.Contact;

public interface ExcelFileService {
	ByteArrayInputStream export(List<Contact> contacts);
}
