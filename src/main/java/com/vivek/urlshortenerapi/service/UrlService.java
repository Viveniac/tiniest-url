package com.vivek.urlshortenerapi.service;

import com.vivek.urlshortenerapi.dto.UrlLongRequest;
import com.vivek.urlshortenerapi.entity.Url;
import com.vivek.urlshortenerapi.repository.UrlRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class UrlService {

    private final UrlRepository urlRepository;
    private final BaseConversion conversion;

    private  final String prefix = "http://localhost:8080/";
    
    public UrlService(UrlRepository urlRepository, BaseConversion baseConversion) {
        this.urlRepository = urlRepository;
        this.conversion = baseConversion;
    }

    public String convertToShortUrl(UrlLongRequest request) {
        var url = new Url();
        url.setLongUrl(request.getLongUrl());
        var entity = urlRepository.save(url);
        /*System.out.println("http://localhost:8080/"+ conversion.encode(entity.getId()));*/
        return prefix + conversion.encode(entity.getId());
    }

    public String getOriginalUrl(String shortUrl) {
        var id = conversion.decode(shortUrl);
        var entity = urlRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("There is no entity with " + shortUrl));
        return entity.getLongUrl();
    }
}
