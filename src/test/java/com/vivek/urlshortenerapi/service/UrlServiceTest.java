package com.vivek.urlshortenerapi.service;

import com.vivek.urlshortenerapi.dto.UrlLongRequest;
import com.vivek.urlshortenerapi.entity.Url;
import com.vivek.urlshortenerapi.repository.UrlRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;


import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UrlServiceTest {

    @Mock
    UrlRepository mockUrlRepository;

    @Mock
    BaseConversion mockBaseConversion;

    @InjectMocks
    UrlService urlService;

    @Test
    public void convertToShortUrlTest() {
        var url = new Url();
        url.setLongUrl("https://www.google.com/search?q=Neueda&rlz=1C1NDCM_enUS756US756&sxsrf=ALeKk01qfsZAAXe7pcqow2xfn7hNKTtSgw%3A1627051374352&ei=btX6YPLzFJaH1fAPofaJuAs&oq=Neueda&gs_lcp=Cgdnd3Mtd2l6EAMyBAgjECcyBAgjECcyCggAELEDEIMBEEMyDQguELEDEMcBEKMCEEMyBwgAELEDEEMyCgguEMcBEKMCEEMyCgguELEDEIMBEEMyBAgAEEMyDQguELEDEMcBEKMCEEMyBAgAEEM6BAgAEEc6CwguELEDEMcBEKMCOggIABCxAxCDAToFCAAQsQNKBAhBGABQ3AlYnh9g2ypoAHADeAGAAe8CiAGSBpIBBzAuMS4xLjGYAQCgAQGqAQdnd3Mtd2l6sAEIyAEIwAEB&sclient=gws-wiz&ved=0ahUKEwjy4svZtvnxAhWWQxUIHSF7ArcQ4dUDCA8&uact=5");
        url.setId(5);

        when(mockUrlRepository.save(any(Url.class))).thenReturn(url);
        when(mockBaseConversion.encode(url.getId())).thenReturn("f");

        var urlRequest = new UrlLongRequest();
        urlRequest.setLongUrl("https://www.google.com/search?q=Neueda&rlz=1C1NDCM_enUS756US756&sxsrf=ALeKk01qfsZAAXe7pcqow2xfn7hNKTtSgw%3A1627051374352&ei=btX6YPLzFJaH1fAPofaJuAs&oq=Neueda&gs_lcp=Cgdnd3Mtd2l6EAMyBAgjECcyBAgjECcyCggAELEDEIMBEEMyDQguELEDEMcBEKMCEEMyBwgAELEDEEMyCgguEMcBEKMCEEMyCgguELEDEIMBEEMyBAgAEEMyDQguELEDEMcBEKMCEEMyBAgAEEM6BAgAEEc6CwguELEDEMcBEKMCOggIABCxAxCDAToFCAAQsQNKBAhBGABQ3AlYnh9g2ypoAHADeAGAAe8CiAGSBpIBBzAuMS4xLjGYAQCgAQGqAQdnd3Mtd2l6sAEIyAEIwAEB&sclient=gws-wiz&ved=0ahUKEwjy4svZtvnxAhWWQxUIHSF7ArcQ4dUDCA8&uact=5");

        assertEquals("f", urlService.convertToShortUrl(urlRequest));
    }

    @Test
    public void getOriginalUrlTest() {
        when(mockBaseConversion.decode("h")).thenReturn((long) 7);

        var url = new Url();
        url.setLongUrl("https://www.google.com/search?q=Neueda&rlz=1C1NDCM_enUS756US756&sxsrf=ALeKk01qfsZAAXe7pcqow2xfn7hNKTtSgw%3A1627051374352&ei=btX6YPLzFJaH1fAPofaJuAs&oq=Neueda&gs_lcp=Cgdnd3Mtd2l6EAMyBAgjECcyBAgjECcyCggAELEDEIMBEEMyDQguELEDEMcBEKMCEEMyBwgAELEDEEMyCgguEMcBEKMCEEMyCgguELEDEIMBEEMyBAgAEEMyDQguELEDEMcBEKMCEEMyBAgAEEM6BAgAEEc6CwguELEDEMcBEKMCOggIABCxAxCDAToFCAAQsQNKBAhBGABQ3AlYnh9g2ypoAHADeAGAAe8CiAGSBpIBBzAuMS4xLjGYAQCgAQGqAQdnd3Mtd2l6sAEIyAEIwAEB&sclient=gws-wiz&ved=0ahUKEwjy4svZtvnxAhWWQxUIHSF7ArcQ4dUDCA8&uact=5");
        url.setId(7);

        when(mockUrlRepository.findById((long) 7)).thenReturn(java.util.Optional.of(url));
        assertEquals("https://www.google.com/search?q=Neueda&rlz=1C1NDCM_enUS756US756&sxsrf=ALeKk01qfsZAAXe7pcqow2xfn7hNKTtSgw%3A1627051374352&ei=btX6YPLzFJaH1fAPofaJuAs&oq=Neueda&gs_lcp=Cgdnd3Mtd2l6EAMyBAgjECcyBAgjECcyCggAELEDEIMBEEMyDQguELEDEMcBEKMCEEMyBwgAELEDEEMyCgguEMcBEKMCEEMyCgguELEDEIMBEEMyBAgAEEMyDQguELEDEMcBEKMCEEMyBAgAEEM6BAgAEEc6CwguELEDEMcBEKMCOggIABCxAxCDAToFCAAQsQNKBAhBGABQ3AlYnh9g2ypoAHADeAGAAe8CiAGSBpIBBzAuMS4xLjGYAQCgAQGqAQdnd3Mtd2l6sAEIyAEIwAEB&sclient=gws-wiz&ved=0ahUKEwjy4svZtvnxAhWWQxUIHSF7ArcQ4dUDCA8&uact=5", urlService.getOriginalUrl("h"));

    }
}
