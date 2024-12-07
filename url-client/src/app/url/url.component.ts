import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-url',
  templateUrl: './url.component.html',
  styleUrls: ['./url.component.css']
})
export class UrlComponent {

  private apiUrl = 'http://localhost:8080/api/url';
  private baseUrl = 'http://localhost:4200/';

  url: string = '';
  shortenedUrl: string = '';
  response: string | null = null;

  constructor(private http: HttpClient) {}

  // Method to interact with the API
  shortUrl(url: string): Observable<any> {
    return this.http.post(this.apiUrl, { url });
  }

  // Method to handle the shortening process
  shorten(): void {
    if (!this.url.trim()) {
      console.error('Error: URL is empty.');
      return;
    }

    this.shortUrl(this.url).subscribe({
      next: (res) => {
        this.response = res.code;
        console.log(this.response);
        this.shortenedUrl = this.baseUrl + this.response;
      },
      error: (err) => {
        console.error('Error:', err);
      }
    });
  }
}
