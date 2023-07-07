export interface ProjectUpdateDto {
    id: number;
    projectNumber: number;
    projectName: string;
    customer: string;
    groupId: number;
    members: number[];
    status: string;
    startDate: Date;
    endDate: Date;
}