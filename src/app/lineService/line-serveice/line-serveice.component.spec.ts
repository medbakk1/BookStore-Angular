import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LineServeiceComponent } from './line-serveice.component';

describe('LineServeiceComponent', () => {
  let component: LineServeiceComponent;
  let fixture: ComponentFixture<LineServeiceComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LineServeiceComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(LineServeiceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
