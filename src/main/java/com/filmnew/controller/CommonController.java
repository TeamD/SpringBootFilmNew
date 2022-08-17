package com.filmnew.controller;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;

import com.filmnew.Service.UserService;

public class CommonController{
	ModelAndView mv = new ModelAndView();
	@Autowired
	UserService userService;
	String urlPosterNothing = "https://image.tmdb.org/t/p/w500/cR6rQDFpMOQp2LzB6vL4ZcaDo1j.jpg";
	private final String urlImage = "https://image.tmdb.org/t/p/original";
	private final String urlBigImage = "https://image.tmdb.org/t/p/w500";
	private final String urlFindWithKeyword = "https://api.themoviedb.org/3/search/movie?api_key=b7c3309b3ea8fdf5c9afa62154eefc7f&language=en-US&page=1&include_adult=false&query=";
	private final String urlTrending = "https://api.themoviedb.org/3/trending/all/day?api_key=b7c3309b3ea8fdf5c9afa62154eefc7f";
	private final String urlTopRated = "https://api.themoviedb.org/3/movie/top_rated?api_key=b7c3309b3ea8fdf5c9afa62154eefc7f&language=en-US&page=1";
	private String urlDetailFilm(String idFilm) {
		return "https://api.themoviedb.org/3/movie/"+idFilm+"?api_key=b7c3309b3ea8fdf5c9afa62154eefc7f&append_to_response=videos";
	}
	public String getURLImage(String url) {
		return urlBigImage+url;
	}
	private String getUrlPopular(String page) {
		return "https://api.themoviedb.org/3/movie/popular?api_key=b7c3309b3ea8fdf5c9afa62154eefc7f&language=en-US&page="+page;
	}
	private String getVideo(String id) {
		return "https://api.themoviedb.org/3/movie/"+id+"/videos?api_key=b7c3309b3ea8fdf5c9afa62154eefc7f&language=en-US";
	}
	private String getUrlCasts(String id) {
		return "http://api.themoviedb.org/3/movie/"+id+"/casts?api_key=b7c3309b3ea8fdf5c9afa62154eefc7f";
	}
	private String getUrlReview(String id) {
		return "https://api.themoviedb.org/3/movie/"+id+"/reviews?api_key=b7c3309b3ea8fdf5c9afa62154eefc7f&language=en-US&page=1";
	}
	public String findWithKeyword(String keyword) throws URISyntaxException, IOException, InterruptedException {
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create(urlFindWithKeyword + keyword))
				.method("GET", HttpRequest.BodyPublishers.noBody())
				.build();
		HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
		return response.body();
	}
	public String getDetailFilm(String idFilm) throws URISyntaxException, IOException, InterruptedException {
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create(urlDetailFilm(idFilm)))
				.method("GET", HttpRequest.BodyPublishers.noBody())
				.build();
		HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
		return response.body();
	}
	public String getDetailwPage(String page) throws URISyntaxException, IOException, InterruptedException {
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create(getUrlPopular(page)))
				.method("GET", HttpRequest.BodyPublishers.noBody())
				.build();
		HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
		return response.body();
	}
	public String getVideos(String idFilm) throws URISyntaxException, IOException, InterruptedException {
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create(getVideo(idFilm)))
				.method("GET", HttpRequest.BodyPublishers.noBody())
				.build();
		HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
		return response.body();
	}
	public String getCasts(String idFilm) throws URISyntaxException, IOException, InterruptedException {
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create(getUrlCasts(idFilm)))
				.method("GET", HttpRequest.BodyPublishers.noBody())
				.build();
		HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
		return response.body();
	}
	public String getReviews(String idFilm) throws URISyntaxException, IOException, InterruptedException {
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create(getUrlReview(idFilm)))
				.method("GET", HttpRequest.BodyPublishers.noBody())
				.build();
		HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
		return response.body();
	}
	public String getTrending() throws URISyntaxException, IOException, InterruptedException {
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create(urlTrending))
				.method("GET", HttpRequest.BodyPublishers.noBody())
				.build();
		HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
		return response.body();
	}
	public String getTopRated() throws URISyntaxException, IOException, InterruptedException {
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create(urlTopRated))
				.method("GET", HttpRequest.BodyPublishers.noBody())
				.build();
		HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
		return response.body();
	}
}
