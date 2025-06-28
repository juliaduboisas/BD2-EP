import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StudentDetailsModal } from './student-details-modal';

describe('StudentDetailsModal', () => {
  let component: StudentDetailsModal;
  let fixture: ComponentFixture<StudentDetailsModal>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [StudentDetailsModal]
    })
    .compileComponents();

    fixture = TestBed.createComponent(StudentDetailsModal);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
