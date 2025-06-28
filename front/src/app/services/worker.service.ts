import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface Worker {
  cpf: string;
  nome: string;
  cargo: string;
  salario: number;
  email: string;
  cep: string;
  numero: number;
  complemento: string;
  data_admissao: string;
  cpf_adm: string; // Foreign key for administrator CPF
  // Add other fields as per your Worker model if available
}

@Injectable({
  providedIn: 'root'
})
export class WorkerService {
  private apiUrl = 'api/worker'; // As per funcionario-controller

  constructor(private http: HttpClient) { }

  getAllWorkers(): Observable<Worker[]> {
    return this.http.get<Worker[]>(this.apiUrl);
  }

  getWorkerByCpf(cpf: string): Observable<Worker> {
    return this.http.get<Worker>(`${this.apiUrl}/${cpf}`);
  }

  // Not adding add/update/delete here as they are not immediately needed for Turma logic
}