import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ModalityForm } from './modality-form';

describe('ModalityForm', () => {
  let component: ModalityForm;
  let fixture: ComponentFixture<ModalityForm>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ModalityForm]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ModalityForm);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
