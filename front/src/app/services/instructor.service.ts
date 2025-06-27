import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, forkJoin, of } from 'rxjs'; // Import forkJoin and of
import { map, catchError } from 'rxjs/operators'; // Import map and catchError
import { WorkerService, Worker } from './worker.service'; // Import WorkerService and Worker interface

// This interface now reflects what we expect to get from the /api/instructor endpoint directly,
// assuming 'nome' is *not* part of it. The 'nome' will be added in the service method.
export interface Instructor {
  cpf: string;
  especializacao: string;
  // If 'nome' is indeed not part of the /api/instructor endpoint, it should not be here.
  // For the composite object returned by the service method, we'll add 'nome'.
}

// Composite Instructor type that includes the name from the worker service
export interface FullInstructor extends Instructor {
  nome: string; // Name explicitly added for the composite object
}

@Injectable({
  providedIn: 'root'
})
export class InstructorService {
  private apiUrl = 'api/instrutor';

  constructor(
    private http: HttpClient,
    private workerService: WorkerService // Inject WorkerService
  ) { }

  getAllInstructors(): Observable<FullInstructor[]> {
    // This method will need a similar composite logic if it's used to list all instructors with names.
    // For now, we'll implement getInstructorByCpf with composite logic.
    // If getAllInstructors is used in a dropdown, it might also need worker names.
    // For simplicity of this task, focusing on getInstructorByCpf.
    return this.http.get<FullInstructor[]>(this.apiUrl); // Assuming this endpoint now provides 'nome' or backend handles composite
  }

  getInstructorByCpf(cpf: string): Observable<FullInstructor | null> {
    const instructorDetails$ = this.http.get<Instructor>(`${this.apiUrl}/${cpf}`).pipe(
      catchError(err => {
        console.error(`Error fetching instructor details for ${cpf} from /instructor:`, err);
        return of(null); // Return null if instructor details fail
      })
    );

    const workerDetails$ = this.workerService.getWorkerByCpf(cpf).pipe(
      catchError(err => {
        console.error(`Error fetching worker details for ${cpf} from /worker:`, err);
        return of(null); // Return null if worker details (name) fail
      })
    );

    return forkJoin([instructorDetails$, workerDetails$]).pipe(
      map(([instructor, worker]) => {
        if (instructor && worker) {
          // Combine the data to create a 'FullInstructor' object
          return {
            ...instructor,
            nome: worker.nome // Get name from worker details
          } as FullInstructor;
        } else if (instructor) {
          // If worker details are missing, return instructor with a placeholder name
          return { ...instructor, nome: 'Nome indisponível' } as FullInstructor;
        }
        return null; // If basic instructor details are missing
      })
    );
  }
}