import { Component, OnInit } from '@angular/core';
import { Client } from '../models/client';
import { ClientService } from '../client.service';

@Component({
  selector: 'app-clients',
  templateUrl: './clients.component.html',
  styleUrls: ['./clients.component.css']
})
export class ClientsComponent implements OnInit {

  clients: Client[] = [];
  clientId = 0;
  clientName = "";
  clientCIN:number = 0;
  clientTel:number = 0;

  client2 = new Client();
  currentClient = new Client();

  




  constructor(private service :ClientService) { 
    
  }

  ngOnInit(): void {
   this.service.listeClients().subscribe(prods => {
      this.clients = prods;
    });
    

  }
  onUpdateClient(id:number){
    this.currentClient=this.service.consulterClient(id)
    this.clientId=this.currentClient.id
    this.clientName=this.currentClient.nom
    this.clientCIN=this.currentClient.cin
    this.clientTel=this.currentClient.tel

  }
  onDeleteClient(id:number){
    this.service.deleteClient(id).subscribe()
    window.location.reload();
    
    


  }
  onAddNewClient(){
    this.client2.id=this.clientId
    this.client2.nom = this.clientName;
    this.client2.cin = this.clientCIN;
    this.client2.tel = this.clientTel;
    this.service.addClient(this.client2).subscribe();
    window.location.reload();
   }
   confirmClient(){
    this.client2.id=this.clientId
    this.client2.nom = this.clientName;
    this.client2.cin = this.clientCIN;
    this.client2.tel = this.clientTel;
    this.service.updateClient(this.client2.id,this.client2).subscribe();
    window.location.reload();
   }


}
