import { Component, OnInit } from '@angular/core';
import { Router, RouterModule } from '@angular/router';
import { CommonModule } from '@angular/common';
import { MatDialog } from '@angular/material/dialog';
import { Modality, ModalityService } from '../../../services/modality.service';
import { ModalityForm } from '../modality-form/modality-form';
import { ConfirmDialogComponent } from '../../confirm-dialog/confirm-dialog';

@Component({
  selector: 'app-modalities-list',
  standalone: true,
  imports: [RouterModule, CommonModule],
  templateUrl: './modalities-list.html',
  styleUrls: ['./modalities-list.css']
})
export class ModalitiesList implements OnInit {
  modalities: Modality[] = [];

  constructor(
    private modalityService: ModalityService,
    private router: Router,
    public dialog: MatDialog
  ) {}

  ngOnInit(): void {
    this.loadModalities();
  }

  loadModalities(): void {
    this.modalityService.getAllModalities().subscribe({
      next: (data) => {
        this.modalities = data;
      },
      error: (error) => {
        console.error('Erro ao carregar modalidades:', error);
      }
    });
  }

  createNewModality(): void {
    const dialogRef = this.dialog.open(ModalityForm, {
      data: { isEdit: false },
      width: '400px'
    });

    dialogRef.afterClosed().subscribe(result => {
      if (result) {
        this.loadModalities();
      }
    });
  }

  deleteModality(id: string | undefined): void {
    if (!id) {
        alert('Não é possível remover. Modalidade não possui ID.');
        return;
    }

    const dialogRef = this.dialog.open(ConfirmDialogComponent, {
      data: { message: 'Tem certeza que deseja remover esta modalidade?' }
    });

    dialogRef.afterClosed().subscribe(result => {
      if (result) {
        // Activate the actual delete call now that the endpoint is available
        this.modalityService.deleteModality(id).subscribe({
          next: () => {
            alert('Modalidade removida com sucesso!');
            this.loadModalities(); // Reload the list
          },
          error: (error) => {
            console.error('Erro ao remover modalidade:', error);
            alert('Erro ao remover modalidade. Verifique o console.');
          }
        });
      }
    });
  }
}