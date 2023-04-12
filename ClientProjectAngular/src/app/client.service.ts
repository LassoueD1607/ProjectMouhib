import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Client } from './models/client';
import { HttpClient, HttpHeaders } from '@angular/common/http';



@Injectable({
  providedIn: 'root'
})
export class ClientService {
  readonly apiURL = "http://localhost:8080/api/v1/clients";
  clients : Client[]=[]


  constructor(private http: HttpClient) { 
    this.listeClients().subscribe(prods => {
      this.clients = prods;
    });
  }



  listeClients(): Observable<Client[]> {
    return this.http.get<Client[]>(this.apiURL);
  }
  addClient(data: Client) {
    return this.http.post(this.apiURL , data);
  }
  updateClient(id: number | string, data: Client) {
    return this.http.put(this.apiURL + `/${id}`, data)
  }
  deleteClient(id: number | string) {
    return this.http.delete(this.apiURL + `/${id}`)
  }
  consulterClient(id: number): any {
  
    return this.clients.find(p => p.id == id);

  }
}
