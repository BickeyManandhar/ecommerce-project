import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Product } from '../common/product';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  private baseUrl = 'http://localhost:8081/product';

  constructor(private httpClient: HttpClient) { }

  // Observable = a stream of asynchronous data.
  // We use subscribe() to get the emitted value(s).
  // Angular’s HttpClient returns Observable because HTTP calls are asynchronous.
  // We can combine, transform, or cancel them using RxJS.
  getProductList(): Observable<Product[]> {
    return this.httpClient.get<Product[]>(this.baseUrl);
  }

  getProduct(id: number): Observable<Product> {
    return this.httpClient.get<Product>(`${this.baseUrl}/${id}`);
  }
}
